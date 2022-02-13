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
import model.Account;
import model.Feature;
import model.Group;

/**
 *
 * @author Admin
 */
public class BaseDAO extends DBContext {

    public Account getAccountByUserNameAndPassWord(String username, String password) {
        try {
            String sql = "Select a.username,a.password,case when g.gid IS NULL then -1 else g.gid end as 'gid',g.name,f.fid,f.url\n"
                    + "from Account a left join [GroupAccount] gA \n"
                    + "on a.username = gA.username  left join [Group] g\n"
                    + "on gA.gid = g.gid left join [FeatureGroup] fG\n"
                    + "on g.gid = fG.gid left join [Feature] f \n"
                    + "on fG.fid = f.fid\n"
                    + "where a.username = ? and a.password = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();

            Account acc = null;
            Group g = new Group();
            g.setId(-1);
            while (rs.next()) {
                if (acc == null) {
                    acc = new Account();
                    acc.setUserName(username);
                    acc.setPassWord(password);
                }
                int gid = Integer.parseInt(rs.getString("gid"));
                if (gid != -1) {
                    if (gid != g.getId()) {
                        g = new Group();
                        g.setId(gid);
                        g.setName(rs.getString("name"));
                        acc.getListGroup().add(g);
                    }
                    Feature f = new Feature();
                    f.setId(Integer.parseInt(rs.getString("fid")));
                    f.setUrl(rs.getString("url"));
                    g.getListFeature().add(f);
                }
            }
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
