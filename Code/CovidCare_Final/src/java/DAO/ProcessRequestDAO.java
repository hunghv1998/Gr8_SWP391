/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class ProcessRequestDAO extends DBContext {

    public void acceptRequestPost(int requestId) {
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE [dbo].[RequestVaccinate]\n"
                    + "   SET   [status] = '1'\n"
                    + " WHERE id=?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, requestId);
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

    public void denieRequestVaccinate(int requestId) {
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE [dbo].[RequestVaccinate]\n"
                    + "   SET   [status] = '3'\n"
                    + " WHERE id=?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, requestId);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
}
