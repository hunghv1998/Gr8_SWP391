/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Controller.ServerController;
import Model.User;
import com.sun.xml.wss.impl.misc.SecurityUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class UserDAO extends DBPoolManager {

    public Integer getUserIdWithName(String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int userId = -1;
        String sql = "Select userId from users where username = '" + username + "'";

        try {
            ResultSet rs = getData(sql);

            boolean userExisted = rs.next();
            if (userExisted) {
                userId = rs.getInt("userId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userId;
    }

    public Integer insertUser(User user) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int n = 0;
        String sql1 = "SELECT * FROM users WHERE username = " + user.getUsername();
        String sql2 = "INSERT INTO users(username, password, userType) VALUES (?,?,?)";

        ResultSet rs = getData(sql1);

        try {
            if (rs.next()) {
                n = -1;
            } else {
                PreparedStatement statement = connection.prepareStatement(sql2);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.setInt(3, user.getUserType());
                n = statement.executeUpdate();
                ServerController.shouldUpdateUsersCache = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Boolean checkIfAdmin(Integer initiatedById) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean isAdmin = false;
        String sql = "SELECT * FROM users WHERE userId = " + initiatedById;
        
        ResultSet rs = getData(sql);
        
        try {
            if (rs.next()) {
                isAdmin = (rs.getInt("userType") == 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAdmin;
    }

    public String getUserNameWithId(Integer userId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String username = null;
        String sql = "SELECT username FROM users WHERE userId=" + userId;
        
        ResultSet rs = getData(sql);
        
        try {
            if (rs.next()) {
                username = rs.getString("username");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return username;
    }

    public Integer deleteUser(Integer userId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int result = -1;
        String sql = "DELETE FROM users WHERE userId = ?";
        
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            result = statement.executeUpdate();
            ServerController.shouldUpdateUsersCache = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
