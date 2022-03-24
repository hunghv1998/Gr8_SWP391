/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.PostVaccinate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PostVaccineDAO extends DBContext {

    public ArrayList<PostVaccinate> getListPostVaccinate(String username) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        PostVaccinate pv = null;
        ArrayList<PostVaccinate> listPV = new ArrayList<>();

        try {
            String sql = "select p.id,p.created_by,p.creted_date,p.vaccId,p.expired_date,p.place,p.wardId,p.number_vaccin,p.start_date,p.note,p.status,v.vaccName  from PostVaccinate p left join Vaccine v \n"
                       + "on v.vaccId = p.vaccId\n"
                       + "where created_by = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                pv = new PostVaccinate();
                pv.setId(rs.getInt("id"));
                pv.setCreatedBy(rs.getString("created_by"));
                pv.setCreatedDate(rs.getString("creted_date"));
                pv.setVaccId(rs.getInt("vaccId"));
                pv.setExpiredDate(rs.getString("expired_date"));
                pv.setPlace(rs.getString("place"));
                pv.setWardId(rs.getInt("wardId"));
                pv.setAmount(rs.getInt("number_vaccin"));
                pv.setStartDate(rs.getString("start_date"));
                pv.setNote(rs.getString("note"));
                pv.setStatus(rs.getBoolean("status"));
                pv.setVaccName(rs.getString("vaccName"));
                listPV.add(pv);
            }
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
                    + "           ,[number_vaccin]\n"
                    + "           ,[start_date]\n"
                    + "           ,[note]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pv.getCreatedBy());
            stm.setString(2, pv.getCreatedDate());
            stm.setInt(3, pv.getVaccId());
            stm.setString(4, pv.getExpiredDate());
            stm.setString(5, pv.getPlace());
            stm.setInt(6, pv.getWardId());
            stm.setInt(7, pv.getAmount());
            stm.setString(8, pv.getStartDate());
            stm.setString(9, pv.getNote());
            stm.setBoolean(10, pv.isStatus());

            return stm.executeUpdate();
        } catch (Exception e) {

        }
        return -1;
    }

    public void setDeActivePost(int postId) {

    }

    public PostVaccinate getPostById(int id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        PostVaccinate pv = null;
        try {
            String sql = "select * from PostVaccinate "
                    + "where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                pv = new PostVaccinate();

                pv.setId(rs.getInt("id"));
                pv.setCreatedBy(rs.getString("created_by"));
                pv.setCreatedDate(rs.getString("creted_date"));
                pv.setVaccId(rs.getInt("vaccId"));
                pv.setExpiredDate(rs.getString("expired_date"));
                pv.setPlace(rs.getString("place"));
                pv.setWardId(rs.getInt("wardId"));
                pv.setAmount(rs.getInt("number_vaccin"));
                pv.setStartDate(rs.getString("start_date"));
                pv.setNote(rs.getString("note"));
                pv.setStatus(rs.getBoolean("status"));
            }

            return pv;
        } catch (Exception e) {

        }
        return null;
    }

}
