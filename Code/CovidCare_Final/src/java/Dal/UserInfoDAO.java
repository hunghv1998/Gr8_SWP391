/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.UserInfo;
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

    public UserInfo getUserInfo(String username) {
        UserInfo userinfo = new UserInfo();

        String sql = "SELECT * FROM UserInfo where uname = '" + username + "'";
        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                userinfo.setBday(rs.getDate(2));
                userinfo.setSex(rs.getBoolean(3));
                userinfo.setEmail(rs.getString(4));
                userinfo.setImage(rs.getString(5));
                userinfo.setAddress(rs.getString(6));
                userinfo.setName(rs.getString(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return userinfo;
    }

    public int UpdateUserInfo(UserInfo userinfo, String username) {
        int n = 0;

        String sql = "UPDATE UserInfo SET "
                + "bday=?,"
                + "sex=?,"
                + "email=?,"
                + "image=?,"
                + "address=?,"
                + "name=?,"
                + "firstTimeLogin=?"
                + " where uname=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setDate(1, userinfo.getBday());
            pre.setBoolean(2, userinfo.isSex());
            pre.setString(3, userinfo.getEmail());
            pre.setString(4, userinfo.getImage());
            pre.setString(5, userinfo.getAddress());
            pre.setString(6, userinfo.getName());
            pre.setBoolean(7, true);
            pre.setString(8, username);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

//    public int UpdateUserInfo(String username, String bod,String sex,String email,String image,String address,String name,String uname) {
//        String sql = "INSERT INTO [dbo].[UserInfo]\n"
//                + "           ([userId]\n"
//                + "           ,[bday]\n"
//                + "           ,[sex]\n"
//                + "           ,[email]\n"
//                + "           ,[image]\n"
//                + "           ,[address]\n"
//                + "           ,[name]\n"
//                + "           ,[uname])\n"
//                + "     VALUES\n"
//                + "           (?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//    }
}
