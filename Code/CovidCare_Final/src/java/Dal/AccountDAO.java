/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.Account;
import Model.Feature;
import Model.Group;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AccountDAO extends DBContext {

    public boolean checkAccountExist(String username) throws SQLException {
        int n = 0;
        String sql = "select username from Account where username ='" + username + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                n = n + 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (n > 0) {
            return true;
        }
        return false;
    }

    public int signup(String username, String password) {
        int n = 0;
        String sql = "INSERT INTO Account(username, password) VALUES (?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Account getAccountByUsernameAndPassword(String username, String password) {
        try {
            String sql = "Select a.username,a.password,case when g.gid IS NULL then -1 else g.gid end as 'gid',g.name,f.fid,f.url\n"
                    + "from Account a left join [GroupAccount] gA \n"
                    + "on a.username = gA.username  left join [Group] g\n"
                    + "on gA.gid = g.gid left join [GroupFeature] fG\n"
                    + "on g.gid = fG.gid left join [Feature] f\n"
                    + "on fG.fid = f.fid\n"
                    + "where a.username = ? and a.password = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();

            Group g = new Group();
            g.setId(-1);
            Account acc = null;

            while (rs.next()) {
                if (acc == null) {
                    acc = new Account();
                    acc.setUserName(username);
                    acc.setPassWord(password);
                }

                if (g.getId() != Integer.parseInt(rs.getString("gid"))) {
                    g.setId(Integer.parseInt(rs.getString("gid")));
                    g.setName(rs.getString("name"));
                    acc.setGroupId(g.getId());
                    acc.getListGroup().add(g);
                }
                Feature f = new Feature();
                f.setId(rs.getString("fid"));
                f.setUrl(rs.getString("url"));
                g.getListFeature().add(f);
            }
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDAO aD = new AccountDAO();
        Account acc = aD.getAccountByUsernameAndPassword("Chinh123", "123");
        System.out.println(acc.getGroupId());
        for (Group g : acc.getListGroup()) {
            System.out.println(g.toString());
            for (Feature f : g.getListFeature()) {
                System.out.println(f.toString());
            }
        }

    }

    public ArrayList<Account> getAcc() {
        ArrayList<Account> list = new ArrayList<>();

        String sql = "SELECT a.username, a.password , g.name FROM Account a \n"
                + "INNER JOIN GroupAccount ga On a.username=ga.username\n"
                + "INNER JOIN [Group] g On ga.gid = g.gid";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                Group g = new Group();
                g.setName(rs.getString("name"));
                Account a = new Account();
                a.setUserName(rs.getString("username"));
                a.setPassWord(rs.getString("password"));
                a.setGroup(g);
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void deleteAccountByUsername(String username) {
        deleteGroupAccountByUsername(username);
        try {
            String sql = "DELETE FROM Account"
                    + "      WHERE username = ? ";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteGroupAccountByUsername(String username) {
        try {
            String sql = "DELETE FROM [dbo].[GroupAccount]\n"
                    + "      WHERE username = ? ";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertAccount(String username, String password) {
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([username]\n"
                    + "           ,[password])\n"
                    + "     VALUES\n"
                    + "           (?,?)";

            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            return pre.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void insertRole(String username,String password, String role) {
       int a =  insertAccount(username,password);
        try {
            String sql = "INSERT INTO [dbo].[GroupAccount]\n"
                    + "           ([username]\n"
                    + "           ,[gid])\n"
                    + "     VALUES\n"
                    + "           (\n"
                    + "           ?,?)";

            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, role);
            pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
