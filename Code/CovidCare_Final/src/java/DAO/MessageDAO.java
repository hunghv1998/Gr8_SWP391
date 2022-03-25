/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChatRoom;
import Model.Message;
import Model.User;
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
public class MessageDAO extends DBContext {

    public void markMsgsAsRead(Integer fromId, Integer toId) {
        String sql = "UPDATE Message SET readState=1 WHERE fromId=" + toId + " AND toId=" + fromId;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertMessage(Message message) {
        String sql = "INSERT INTO Message(fromId, toId, message, messageDate, readState) "
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
        String sql = "SELECT * from Message WHERE "
                + "(toId = " + toId + " AND fromId = " + fromId + ") OR "
                + "(toId = " + fromId + " AND fromId = " + toId + ")";
        ArrayList<Message> chat = new ArrayList<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                Message message = new Message();
                message.setFromId(rs.getInt("fromId"));
                message.setToId(rs.getInt("toId"));
                message.setMessage(rs.getString("message"));
                message.setMessageDate(rs.getTimestamp("messageDate"));
                message.setReadState(rs.getInt("readState"));
                chat.add(message);
            }
            return chat;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<ChatRoom> getPatientChatRooms(Integer toId) {
        ArrayList<ChatRoom> listOfChatRooms = new ArrayList<>();

        String sql = "SELECT m.fromId, m.toId, h.name, h.photo, m.message, m.messageDate "
                + "FROM Message m "
                + "JOIN Hospital h "
                + "ON m.fromId = h.userId "
                + "WHERE m.toId=" + toId + " "
                + "ORDER BY m.messageDate DESC";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                ChatRoom chatRoom = new ChatRoom();

                chatRoom.setFromId(rs.getInt("fromId"));
                chatRoom.setToId(rs.getInt("toId"));
                chatRoom.setSenderName(rs.getString("name"));
                chatRoom.setSenderPhoto(rs.getString("photo"));
                chatRoom.setLastMessage(rs.getString("message"));
                chatRoom.setLastMessageTime(rs.getTimestamp("messageDate"));

                Integer foundAt = -1;

                for (int i = 0; i < listOfChatRooms.size(); i++) {
                    if (chatRoom.getFromId() == listOfChatRooms.get(i).getFromId()) {
                        foundAt = i;
                    }
                }
                if (foundAt == -1) {
                    listOfChatRooms.add(chatRoom);
                }
            }
            return listOfChatRooms;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<ChatRoom> getHospitalChatRooms(Integer toId) {
        ArrayList<ChatRoom> listOfChatRooms = new ArrayList<>();

        String sql = "SELECT m.fromId, m.toId, p.name, p.photo, m.message, m.messageDate "
                + "FROM Message m "
                + "JOIN Patient p "
                + "ON m.fromId = p.patientId "
                + "WHERE m.toId=" + toId + " "
                + "ORDER BY m.messageDate DESC";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                ChatRoom chatRoom = new ChatRoom();

                chatRoom.setFromId(rs.getInt("fromId"));
                chatRoom.setToId(rs.getInt("toId"));
                chatRoom.setSenderName(rs.getString("name"));
                chatRoom.setSenderPhoto(rs.getString("photo"));
                chatRoom.setLastMessage(rs.getString("message"));
                chatRoom.setLastMessageTime(rs.getTimestamp("messageDate"));

                Integer foundAt = -1;

                for (int i = 0; i < listOfChatRooms.size(); i++) {
                    if (chatRoom.getFromId() == listOfChatRooms.get(i).getFromId()) {
                        foundAt = i;
                    }
                }
                if (foundAt == -1) {
                    listOfChatRooms.add(chatRoom);
                }
            }
            return listOfChatRooms;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<User> getListOfSenders(Integer toId) {
        ArrayList<User> listOfSenders = new ArrayList<>();

        String sql = "SELECT fromId FROM Message WHERE readState = 0 AND toId = " + toId;
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                UserDAO userDAO = new UserDAO();
                int senderId = rs.getInt("fromId");
                String senderName = userDAO.getUserNameWithId(senderId);

                User userDTO = new User(senderId, senderName);

                Integer foundAt = -1;

                for (int i = 0; i < listOfSenders.size(); i++) {
                    if (senderId == listOfSenders.get(i).getUserId()) {
                        foundAt = i;
                    }
                }
                if (foundAt == -1) {
                    listOfSenders.add(userDTO);
                }
            }
            return listOfSenders;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Message> getChatDialog(Integer toId, Integer fromId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
