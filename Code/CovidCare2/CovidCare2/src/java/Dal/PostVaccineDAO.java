/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.PostVaccinate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PostVaccineDAO extends DBContext {

    public ArrayList<PostVaccinate> getListPostVaccinate(String username) {
        
        ArrayList<PostVaccinate> listPV = new ArrayList<>();
        
        try {

        } catch (Exception e) {

        }
        return listPV;
    }

    public int addPostVaccinate(PostVaccinate pv) {
        try {
            String sql = "INSERT INTO [dbo].[PostVaccinate]\n"
                    + "           ([created_by]\n"
                    + "           ,[creted_date]\n"
                    + "           ,[vaccId]\n"
                    + "           ,[expired_date]\n"
                    + "           ,[place]\n"
                    + "           ,[wardId]\n"
                    + "           ,[number_vaccin])\n"
                    + "           ,[start_date])\n"
                    + "           ,[note])\n"
                    + "           ,[status])\n"
                    + "     VALUES"
                    + "  (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pv.getCreatedBy());
            stm.setDate(2, pv.getCreatedDate());
            stm.setInt(3, pv.getVaccId());
            stm.setDate(4, pv.getExpiredDate());
            stm.setString(5, pv.getPlace());
            stm.setInt(6, pv.getWardId());
            stm.setInt(7, pv.getAmount());
            stm.setDate(8, pv.getStartDate());
            stm.setString(9, pv.getNote());
            stm.setBoolean(10, pv.isStatus());

            return stm.executeUpdate();
        } catch (Exception e) {

        }
        return -1;
    }

    public void setDeActivePost(int postId) {

    }

}
