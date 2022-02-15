/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chinh
 */
public class UserInfoDAO extends DBContext {
    public int SignUpToUserList(String username) {
        int n = 0;
        String sql = "INSERT INTO UserInfo(uname) VALUES(?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public boolean checkFirstLogin(String username) {
        boolean status = true;
        String sql = "SELECT firstTimeLogin from UserInfo where uname='"
                + username + "'";
        ResultSet rs = getData(sql);
        
        try {
            while (rs.next()) {
                status = rs.getBoolean(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
