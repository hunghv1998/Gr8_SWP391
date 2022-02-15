/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AccountDAO extends DBContext {

    public boolean checkAccountExit(String username) throws SQLException {
        String sql = "select username from Account where username = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            String oldUserName = rs.getString("username");
            if (username.equalsIgnoreCase(oldUserName)) {
                return false;
            }
        }
        return true;
    }

    public int insertAccount(String username, String password, String fullname, String phone, String email) {
        try {
            String sql = "INSERT INTO Account (username, password, fullname, phone,email)\n"
                    + "VALUES (?, ?, ?, ?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, sql);
            stm.setString(3, fullname);
            stm.setString(4, phone);
            stm.setString(5, email);
            int updateSuccess = stm.executeUpdate();
            return updateSuccess;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

}
