/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import Model.MessageDTO;
import Model.UserDTO;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArrayBuilder;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;

/**
 *
 * @author chinh
 */
public class ChatSessionHandler {

    protected ArrayList<ConnectedUser> connectedUsersList = new ArrayList<>();

    public void addConnectedUser(ConnectedUser connectedUser) {
        connectedUsersList.add(connectedUser);
    }

    public ArrayList<ConnectedUser> getConnectedUsers() {
        return connectedUsersList;
    }

    public void removeConnectedUser(ConnectedUser connectedUser) {
        connectedUsersList.remove(connectedUser);

        System.out.println("");
    }

    public void sendSomeoneIsWriting(ConnectedUser connectedUser, UserDTO userForm) {
        JsonObject jsonMessage = createWriterMsg(userForm);
        sendToSession(connectedUser.getSession(), jsonMessage);
    }

    public void sendMessage(ConnectedUser toUser, MessageDTO messageToBeSent) {
        JsonObject jsonMessage = createSendMessage(messageToBeSent);
        sendToSession(toUser.getSession(), jsonMessage);
    }

    public void sendAppendMessageNotif(Integer fromId, MessageDTO messageToBeSent) {
        JsonObject jsonMessage = createAppendNot(messageToBeSent);
        for (ConnectedUser connectedUser : connectedUsersList) {
            if (fromId == connectedUser.getUserId()) {
                sendToSession(connectedUser.getSession(), jsonMessage);
            }
        }
    }

    public void sendJArrayTo(ConnectedUser toUser, ArrayList<UserDTO> listOfSenders) {
        JsonArray jsonSendersArray = createJsonArray(listOfSenders);
        sendJArrayToSession(toUser.getSession(), jsonSendersArray);
    }

    public void sendNewUserToAll(UserDTO userForm, Integer initiator) {
        JsonObject newUserMsg = createNewUserMsg(userForm, initiator);
        for (ConnectedUser connectedUser : connectedUsersList) {
            sendToSession(connectedUser.getSession(), newUserMsg);
        }
    }

    public void sendErrorMsgToAdmin(Integer adminId, String username) {
        JsonObject newError = createFailedToAddMsg(adminId, username);
        for (Integer index = 0; index < connectedUsersList.size(); index++) {
            if (connectedUsersList.get(index).getUserId() == adminId) {
                ConnectedUser admin = connectedUsersList.get(index);
                System.out.println("now snding a json response to userId: " + admin.getUserId()
                        + ", message contents: " + newError);
                sendToSession(admin.getSession(), newError);
            }
        }
    }

    public void sendUserDeletedToAll(Integer deletedUserId, Integer initiatedById) {
        JsonObject userDeletedMsg = createUserDeletedMsg(deletedUserId, initiatedById);
        for (ConnectedUser connectedUser : connectedUsersList) {
            System.out.println("now snding a json response to userId: " + connectedUser.getUserId()
                    + ", message contents: " + userDeletedMsg);
        }
    }

    private JsonObject createWriterMsg(UserDTO userForm) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject writerMsg = provider.createObjectBuilder()
                .add("action", "someOneIsTyping")
                .add("fromId", userForm.getUserId())
                .add("senderName", userForm.getUsername())
                .build();
        return writerMsg;
    }

    private JsonObject createSendMessage(MessageDTO messageObj) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject sendMessage = provider.createObjectBuilder()
                .add("action", "receiveMessage")
                .add("sentBy", messageObj.getSentBy())
                .add("fromId", messageObj.getFromId())
                .add("toId", messageObj.getToId())
                .add("messageText", messageObj.getMessage())
                .add("date", messageObj.getMessageDate().toString())
                .add("readState", messageObj.getReadState())
                .build();
        return sendMessage;
    }

    private JsonObject createAppendNot(MessageDTO messageObj) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject notifMessage = provider.createObjectBuilder()
                .add("action", "appendSentMessage")
                .add("sentBy", "me: ")
                .add("fromId", messageObj.getFromId())
                .add("toId", messageObj.getToId())
                .add("messageText", messageObj.getMessage())
                .add("date", messageObj.getMessageDate().toString())
                .add("readState", messageObj.getReadState())
                .build();
        return notifMessage;
    }

    private JsonObject createNewUserMsg(UserDTO userForm, Integer initiator) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject newUserJsonObj = provider.createObjectBuilder()
                .add("action", "recieveNewUser")
                .add("result", "User with userId:" + userForm.getUserId()
                        + ", and userName: " + userForm.getUsername()
                        + " has been successfully added to the database.")
                .add("initiator", initiator)
                .add("userId", userForm.getUserId())
                .add("userName", userForm.getUsername())
                .build();
        return newUserJsonObj;
    }

    private JsonObject createUserDeletedMsg(Integer deletedUserId, Integer initiatedById) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject userDeletedJsonObj = provider.createObjectBuilder()
                .add("action", "userDeleted")
                .add("result", "User with userId:" + deletedUserId
                        + " has been successfully deleted from the database.")
                .add("initiator", initiatedById)
                .add("deletedUserId", deletedUserId)
                .build();
        return userDeletedJsonObj;
    }

    private JsonArray createJsonArray(ArrayList<UserDTO> listOfSenders) {
        JsonProvider provider = JsonProvider.provider();
        JsonArrayBuilder jArrayBulider = provider.createArrayBuilder();
        JsonArray jsonSendersArray;

        JsonObject actionObject = provider.createObjectBuilder()
                .add("action", "processSenders")
                .build();
        jArrayBulider = jArrayBulider.add(actionObject);

        for (UserDTO senderUserDTO : listOfSenders) {

            JsonObject senderJsonObject = provider.createObjectBuilder()
                    .add("fromUserId", senderUserDTO.getUserId())
                    .add("senderName", senderUserDTO.getUsername())
                    .build();

            jArrayBulider = jArrayBulider.add(senderJsonObject);
        }
        jsonSendersArray = jArrayBulider.build();
        if (jsonSendersArray.size() > 0) {
            System.out.println("jsonSendersArray size: " + jsonSendersArray.size() + ", with contents: ");
            System.out.println("action : " + jsonSendersArray.getJsonObject(0).getJsonString("action"));
            for (int index = 1; index < jsonSendersArray.size(); index++) {
                System.out.println(jsonSendersArray.getJsonObject(index).getJsonNumber("fromUserId")
                        + " : "
                        + jsonSendersArray.getJsonObject(index).getJsonString("senderName"));
            }
        }
        return jsonSendersArray;
    }

    private JsonObject createFailedToAddMsg(Integer initiatedByAdminId, String userName) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject failedToAddMsg = provider.createObjectBuilder()
                .add("action", "showFailedToAddUserMsg")
                .add("result", "Username :" + userName + ", already exist in the database, please try another name.")
                .build();
        return failedToAddMsg;
    }

    private void sendToSession(Session session, JsonObject message) {
        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException ex) {
            //comment by me
            //sessions.remove(session);
            Logger.getLogger(ChatSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendJArrayToSession(Session session, JsonArray jsonArray) {
        try {
            session.getBasicRemote().sendText(jsonArray.toString());
        } catch (IOException ex) {
            //comment by me
            //sessions.remove(session);
            Logger.getLogger(ChatSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void sendEarrorMsgToAdmin(Integer initiatedById, String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
