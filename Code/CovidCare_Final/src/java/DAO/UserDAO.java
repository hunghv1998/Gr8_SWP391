/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
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
public class UserDAO extends DBContext {

    public User login(User user) {
        String sql = "SELECT * FROM Users where username='" + user.getUsername()
                + "' AND password='" + user.getPassword() + "'";
        ResultSet rs = getData(sql);
        try {
            if (rs.next()) {
                User result = new User();
                result.setUserId(rs.getInt("userId"));
                result.setUsername(rs.getString("username"));
                result.setUserType(rs.getInt("userType"));
                result.setActiveStatus(rs.getBoolean("activeStatus"));
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer addUser(User user) {
        int result = 0;

        String sql = "INSERT INTO Users(username, password, userType) VALUES (?,?,?)";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getPassword());
            pre.setInt(3, user.getUserType());
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Integer changeUserStatus(Integer userId, boolean activeFlag) {
        int result = -1;

        String sql = "UPDATE Users SET activeStatus=? WHERE userId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setBoolean(1, activeFlag);
            pre.setInt(2, userId);
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Integer changePassword(User user) {
        int result = -1;

        String sql = "UPDATE Users SET password=? WHERE userId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user.getPassword());
            pre.setInt(2, user.getUserId());
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Integer updateUser(User user) {
        int result = -1;

        String sql = "UPDATE Users SET username=?, password=?, activeStatus=? WHERE userId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getPassword());
            pre.setBoolean(3, user.isActiveStatus());
            pre.setInt(4, user.getUserId());
            result = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<User> getUsersList() {
        String sql = "SELECT * FROM Users";

        ResultSet rs = getData(sql);

        try {
            ArrayList<User> listOfUsers = new ArrayList<>();

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUsername(rs.getString("username"));
                user.setUserType(rs.getInt("userType"));
                user.setActiveStatus(rs.getBoolean("activeStatus"));
                listOfUsers.add(user);
            }
            return listOfUsers;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer getIdFromUsername(String username) {
        String sql = "SELECT userId FROM Users WHERE username='" + username + "'";
        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                return (rs.getInt("userId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public String getUserNameWithId(int id) {
        String sql = "SELECT username FROM Users WHERE userId=" + id;
        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                return (rs.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer insertUser(User userObj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<User> returnAllUsers(Connection currentConnection, String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean checkIfAdmin(Integer initiatedById) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer deleteUser(Integer userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}