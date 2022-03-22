/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Message;
import WebSocket.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class MessageDAO extends DBPool {

    public void markMsgsAsRead(Integer msgsFromUserId, Integer msgsToUserId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertMessage(Message message) {
        String sql = "INSERT INTO chatDialog(fromId, toId, messageContent, sendDate, readState) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, message.getFromId());
            statement.setInt(2, message.getToId());
            statement.setString(3, message.getMessage());
            statement.setTimestamp(4, message.getMessageDate());
            statement.setInt(5, message.getReadState());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Message> getMessagesBetween(Integer toId, int fromId) {
        String sql = "SELECT fromId, toId, messageContent from chatDialog WHERE "
                + "(toId = " + toId + " AND fromId = " + fromId + ") OR "
                + "(toId = " + fromId + " AND fromId = " + toId + ")";
        ArrayList<Message> chat = new ArrayList<>();
        ResultSet rs = getData(sql);

        try {
            int from = 0;
            int to = 0;
            String message = "";
            while (rs.next()) {
                from = rs.getInt("fromId");
                to = rs.getInt("toId");
                message = rs.getString("messageContent");
                chat.add(new Message(from, to, message));
            }
            return chat;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<UserDTO> getListOfSenders(Integer toId) {
        String sql = "SELECT fromId FROM chatDialog WHERE readState = 0 AND toId = " + toId;
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int senderId = rs.getInt("fromId");
                String senderName = "";
                UserDTO userDTO;

                while (rs.next()) {
                    senderId = rs.getInt("fromId");
                    UserDAO userDAO = new UserDAO();
                    senderName = userDAO.getUserNameWithId(senderId);

                    userDTO = new UserDTO(senderId, senderName);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Message> getChatDialog(Integer toId, Integer fromId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<UserDTO> getListOfSenders(Connection currentConnection, Integer unreadMsgsToUserId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
