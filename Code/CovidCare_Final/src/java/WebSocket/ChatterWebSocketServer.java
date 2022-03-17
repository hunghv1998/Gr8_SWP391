/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import Controller.ChatController;
import DAO.MessageDAO;
import DAO.UserDAO;
import Model.Message;
import Model.User;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.server.ServerEndpoint;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author chinh
 */
@ApplicationScoped
@ServerEndpoint("/chat")
public class ChatterWebSocketServer {

    private MessageDAO messageDAO = new MessageDAO();
    private UserDAO userDAO = new UserDAO();

    private ChatController serverController = new ChatController();

    Integer connectedUserId = 0;

    @Inject
    private ChatSessionHandler connectedUsers;

    @OnOpen
    public void open(Session session) {
        System.out.println("web socket connection session with ID: " + session.getId() + ", has been opened.");
    }

    @OnClose
    public void close(Session session) {
        Integer foundAt = getConnectedUserIndex(connectedUserId);
        if (foundAt != -1) {
            //connectedUsers.removeConnectedUser(foundAt);
            ConnectedUser connectedUserObj = connectedUsers.getConnectedUsers().get(foundAt);
            connectedUsers.removeConnectedUser(connectedUserObj);
        }
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("error thrown in web socket server: " + error.toString());
        Logger.getLogger(ChatterWebSocketServer.class.getName()).log(Level.SEVERE, null, error);
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        try (JsonReader reader = Json.createReader(new StringReader(message))) {
            JsonObject jsonMessage = reader.readObject();

            if ("someOneIsTyping".equals(jsonMessage.getString("action"))) {
                processSomeOneIsTyping(jsonMessage);
            }
            if ("sendMessage".equals(jsonMessage.getString("action"))) {
                processSendMessage(jsonMessage, session);
            }

            if ("setConnectedUserId".equals(jsonMessage.getString("action"))) {
                processSetConnectedUserId(jsonMessage, session);
            }
            if ("getSenders".equals(jsonMessage.getString("action"))) {
                processGetSenders(jsonMessage);
            }
            if ("markMsgsAsRead".equals(jsonMessage.getString("action"))) {
                processMarkMsgsAsRead(jsonMessage);
            }
        }//end of incoming JSON messages processor
    }

    private void processSomeOneIsTyping(JsonObject jsonMessage) {
        Integer senderId = jsonMessage.getInt("fromId");
        Integer toId = jsonMessage.getInt("toId");
        String senderName = jsonMessage.getString("senderName");

        Integer toFoundAt = getConnectedUserIndex(toId);

        if (toFoundAt != -1) {
            UserDTO userForm = new UserDTO(senderId, senderName);
            ConnectedUser connectedUserObj = connectedUsers.getConnectedUsers().get(toFoundAt);
            connectedUsers.sendSomeoneIsWriting(connectedUserObj, userForm);
        }
    }

    private void processSendMessage(JsonObject jsonMessage, Session session) {
        String sentBy = serverController.getUserNameFromDB(connectedUserId);
        Integer fromId = Integer.parseInt(jsonMessage.getString("fromId"));
        Integer toId = Integer.parseInt(jsonMessage.getString("toId"));
        String messageText = jsonMessage.getString("messageText");

        //if String for date is being used
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        GregorianCalendar calendar = new GregorianCalendar();
        String dateStr = format.format(calendar.getTime());
        String messageDate = dateStr;

        Integer readState = 0;

        MessageDTO messageForm = new MessageDTO(sentBy, fromId, toId, messageText, Timestamp.valueOf(messageDate), readState);
        Message messageObj = new Message(fromId, toId, messageText, Timestamp.valueOf(messageDate), readState);

        System.out.println("now message from client params: " + messageForm.toString());
        System.out.println("through web socket session ID: " + session.getId());
        serverController.insertMsgIntoDb(messageObj);

        /*
        //for single tab only logic
        //check if the destination user is connected to server(online). if so, then send the message on socket
        Integer foundAt = getConnectedUserIndex(toId);
        if(foundAt != -1)
        {                    
            ConnectedUser connectedUserObj = connectedUsers.getConnectedUsers().get(foundAt);
            connectedUsers.sendMessage(connectedUserObj, messageForm);
        }
         */
        for (ConnectedUser connectedUserObj : connectedUsers.getConnectedUsers()) {
            if (connectedUserObj.getUserId() == toId) {
                connectedUsers.sendMessage(connectedUserObj, messageForm);
            }
        }
        connectedUsers.sendAppendMessageNotif(fromId, messageForm);
    }

    private void processSetConnectedUserId(JsonObject jsonMessage, Session session) {
        Integer receivedId = Integer.parseInt(jsonMessage.getString("fromId"));
        connectedUserId = receivedId;

        /*
        //single web socket logic, thus single browser tab
         //to prevent duplicate entries and use tha latest provided session connection
         //loop over ids, if id already exist in list, get the index
         //then remove the ConnectedUser object from the list
         Integer foundAt = getConnectedUserIndex(connectedUserId);
         if(foundAt != -1)
         {
         //connectedUsers.removeConnectedUser(foundAt);
         ConnectedUser connectedUserObj = connectedUsers.getConnectedUsers().get(foundAt);
         connectedUsers.removeConnectedUser(connectedUserObj);
         }
         */
        connectedUsers.addConnectedUser(new ConnectedUser(session, receivedId));
        System.out.println("a new ConnectedUser object has been added.");
        for (ConnectedUser connectedUserObj : connectedUsers.getConnectedUsers()) {
            System.out.println("web socket session: " + connectedUserObj.getSession().getId()
                    + ", user Id: " + connectedUserObj.getUserId());
        }
    }

    private void processGetSenders(JsonObject jsonMessage) {
        Integer unreadMsgsToUserId = Integer.parseInt(jsonMessage.getString("unreadMsgsToUserId"));
        Connection currentConnection = serverController.getCurrentConnection();
        System.out.println("should get messages unread by userID: " + unreadMsgsToUserId);
        if (unreadMsgsToUserId != null) {
            if (currentConnection != null) {
                //System.out.println("next will try to fetch msgs from: "+currentUser.getId()+", to:"+toId);
                ArrayList<UserDTO> listOfSenders = messageDAO.getListOfSenders(currentConnection, unreadMsgsToUserId);

                //check if the destination user is connected to server(online). if so, then send the message on socket
                Integer foundAt = getConnectedUserIndex(unreadMsgsToUserId);
                if (foundAt != -1) {
                    ConnectedUser connectedUserObj = connectedUsers.getConnectedUsers().get(foundAt);
                    connectedUsers.sendJArrayTo(connectedUserObj, listOfSenders);
                }
            }
        }
    }

    private void processMarkMsgsAsRead(JsonObject jsonMessage) {
        Integer msgsFromUserId = jsonMessage.getInt("msgsFromUserId");
        Integer msgsToUserId = jsonMessage.getInt("msgsToUserId");
        Connection currentConnection = serverController.getCurrentConnection();
        if (currentConnection != null) {
            messageDAO.markMsgsAsRead(msgsFromUserId, msgsToUserId);
            System.out.println("just called markMsgsAsRead with params, msgsFromUserId:" + msgsFromUserId
                    + ", msgsToUserId: " + msgsToUserId);
        }
    }


    public Integer getConnectedUserIndex(Integer connectedUserId) {
        Integer foundAt = -1;
        for (int index = 0; index < connectedUsers.getConnectedUsers().size(); index++) {
            //System.out.println("at index: "+index+", userId: "+connectedUsers.getConnectedUsers().get(index).getUserId());
            if (connectedUserId == connectedUsers.getConnectedUsers().get(index).getUserId()) {
                foundAt = index;
                //System.out.println("now foundAt value: "+foundAt);
                return foundAt;
            }
        }
        return foundAt;
    }
}
