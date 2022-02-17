/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        boolean status = false;
        String sql = "SELECT firstTimeLogin from UserInfo where uname='"
                + username + "'";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                return (rs.getBoolean(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public int UpdateUserInfo(String username, String bod,String sex,String email,String image,String address,String name,String uname) {
        String sql = "INSERT INTO [dbo].[UserInfo]\n"
                + "           ([userId]\n"
                + "           ,[bday]\n"
                + "           ,[sex]\n"
                + "           ,[email]\n"
                + "           ,[image]\n"
                + "           ,[address]\n"
                + "           ,[name]\n"
                + "           ,[uname])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
