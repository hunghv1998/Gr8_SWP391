/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;

/**
 *
 * @author chinh
 */
@ApplicationScoped
public class ChatSessionHandler {

    static protected ArrayList<ConnectedUser> connectedList = new ArrayList<>();

    public void addConnectedUser(ConnectedUser user) {
        connectedList.add(user);
    }

    public ArrayList<ConnectedUser> getConnectedUsers() {
        return connectedList;
    }

    public void removeConnectedUser(ConnectedUser user) {
        connectedList.remove(user);
    }

    public void sendSomeoneIsWriting(ConnectedUser user, UserDTO userForm) {
        JsonObject jsonMessage = createWriterMsg(userForm);
        sendToSession(user.getSession(), jsonMessage);
    }

    public void sendMessage(ConnectedUser toUser, MessageDTO sentMsg) {
        JsonObject jsonMessage = createSendMessage(sentMsg);
        sendToSession(toUser.getSession(), jsonMessage);
    }

    public void sendAppendMessageNotif(Integer fromId, MessageDTO sentMsg) {
        JsonObject jsonMessage = createAppendNotif(sentMsg);
        for (ConnectedUser user : connectedList) {
            if (fromId == user.getUserId()) {
                sendToSession(user.getSession(), jsonMessage);
            }
        }
    }

    public void sendJArrayTo(ConnectedUser toUser, ArrayList<UserDTO> listOfSenders) {
        JsonArray jsonSendersArray = createJsonArray(listOfSenders);
        sendJArrayToSession(toUser.getSession(), jsonSendersArray);
    }

    public void sendNewUserToAll(UserDTO userForm, Integer initiator) {
        JsonObject newUserMsg = createNewUserMsg(userForm, initiator);
        for (ConnectedUser user : connectedList) {
            sendToSession(user.getSession(), newUserMsg);
        }
    }

    public void sendUserDeletedToAll(Integer deletedUserId, Integer initieatedById) {
        JsonObject userDeletedMsg = createUserDeletedMsg(deletedUserId, initieatedById);
        for (ConnectedUser user : connectedList) {
            sendToSession(user.getSession(), userDeletedMsg);
        }
    }

    private JsonObject createWriterMsg(UserDTO userForm) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject json = provider.createObjectBuilder()
                .add("action", "someOneIsTyping")
                .add("fromId", userForm.getUserId())
                .add("senderName", userForm.getUsername())
                .build();
        return json;
    }

    private JsonObject createSendMessage(MessageDTO msg) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject json = provider.createObjectBuilder()
                .add("action", "receiveMessage")
                .add("sentBy", msg.getSentBy())
                .add("fromId", msg.getFromId())
                .add("toId", msg.getToId())
                .add("messageText", msg.getMessage())
                .add("date", msg.getMessageDate().toString())
                .add("readState", msg.getReadState())
                .build();
        return json;
    }

    private JsonObject createAppendNotif(MessageDTO msg) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject json = provider.createObjectBuilder()
                .add("action", "appendSentMessage")
                .add("sentBy", "me: ")
                .add("fromId", msg.getFromId())
                .add("toId", msg.getToId())
                .add("messageText", msg.getMessage())
                .add("date", msg.getMessageDate().toString())
                .add("readState", msg.getReadState())
                .build();
        return json;
    }

    private JsonObject createNewUserMsg(UserDTO user, Integer initiator) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject newUser = provider.createObjectBuilder()
                .add("action", "recieveNewUser")
                .add("result", "User with userId" + user.getUserId()
                        + ", and username: " + user.getUsername()
                        + " has been successfully added to the database.")
                .add("initiator", initiator)
                .add("userId", user.getUserId())
                .add("username", user.getUsername())
                .build();
        return newUser;
    }

    private JsonObject createUserDeletedMsg(Integer delUserId, Integer initiatedById) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject userDeleted = provider.createObjectBuilder()
                .add("action", "userDeleted")
                .add("result", "User with userId: " + delUserId
                        + "has been successsfully deleted from the database.")
                .add("initiator", initiatedById)
                .add("deletedUserId", delUserId)
                .build();
        return userDeleted;
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
            Logger.getLogger(ChatSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendJArrayToSession(Session session, JsonArray jsonArray) {
        try {
            session.getBasicRemote().sendText(jsonArray.toString());
        } catch (IOException ex) {
            Logger.getLogger(ChatSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
