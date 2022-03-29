/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.RequestVaccinate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class RequestVaccineDAO extends DBContext {
    
    public ArrayList<RequestVaccinate> getListRequsetVaccinate(int userId) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        RequestVaccinate pr = null;
        ArrayList<RequestVaccinate> listRv = new ArrayList<>();
        
        try {
            String sql = "select * from RequestVaccinate\n"
                    + "where created_by=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                pr = new RequestVaccinate();
                
                pr.setCreated_by(userId);
                pr.setCreated_date(rs.getString("created_date"));
                pr.setNote(rs.getString("note"));
                pr.setPhone(rs.getString("phone_number"));
                pr.setImage(rs.getString("image"));
                pr.setStatus(rs.getString("status"));
                
                listRv.add(pr);
            }
            
            return listRv;
        } catch (Exception e) {
            
        }
        return null;
    }
    
    public int addRequestVaccinate(RequestVaccinate rv) {
        try {
            String sql = "INSERT INTO [dbo].[RequestVaccinate]\n"
                    + "           ([created_by]\n"
                    + "           ,[created_date]\n"
                    + "           ,[phone_number]\n"
                    + "           ,[status]\n"
                    + "           ,[note]\n"
                    + "           ,[image])\n"
                    + "     VALUES\n"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setInt(1, rv.getCreated_by());
            stm.setString(2, rv.getCreated_date());
            stm.setString(3, rv.getPhone());
            stm.setString(4, rv.getStatus());
            stm.setString(5, rv.getNote());
            stm.setString(6, rv.getImage());
            
            return stm.executeUpdate();
        } catch (Exception e) {
            
        }
        return -1;
    }
    
    public void setDeActivePost(int postId) {
        
    }
    
    public RequestVaccinate getRequestById(int id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        RequestVaccinate pr = null;
        try {
            String sql = "";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                pr = new RequestVaccinate();
                
            }
            
            return pr;
        } catch (Exception e) {
            
        }
        return null;
    }
    
    public void connectRequestToPost(int post_id, int request_id) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO [dbo].[PostRequest]\n"
                    + "           ([post_id]\n"
                    + "           ,[request_id])\n"
                    + "     VALUES\n"
                    + "           (?,?)";
            
            ps = connection.prepareStatement(sql);
            ps.setInt(1, post_id);
            ps.setInt(2, request_id);
            ps.executeQuery();
        } catch (Exception e) {
            
        }
    }
    
    public int getMaxRequestId() {
        int id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select max(id) as 'id'\n"
                    + "from RequestVaccinate";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
            
        } catch (Exception e) {
            
        }
        return 0;
    }
    
    public ArrayList<RequestVaccinate> getListRequestVaccinateProcess(int id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        RequestVaccinate pr = null;
        ArrayList<RequestVaccinate> listRv = new ArrayList<>();
        
        try {
            String sql = "select r.id,r.created_by,u.username,r.created_date,r.phone_number,r.status,r.note,r.image,pr.post_id from RequestVaccinate r left join PostRequest pr \n"
                    + "                    on r.id = pr.request_id\n"
                    + "					left join users u \n"
                    + "					on r.created_by = u.userId\n"
                    + "\n"
                    + "                   where pr.post_id= ? AND r.status like '2'";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                pr = new RequestVaccinate();
                pr.setId(rs.getInt("id"));
                pr.setCreated_by(rs.getInt("created_by"));
                pr.setCreated_name(rs.getString("username"));
                pr.setCreated_date(rs.getString("created_date"));
                pr.setNote(rs.getString("note"));
                pr.setPhone(rs.getString("phone_number"));
                pr.setImage(rs.getString("image"));
                pr.setStatus(rs.getString("status"));
                
                listRv.add(pr);
            }
            
            return listRv;
        } catch (Exception e) {
            
        }
        return null;
    }
}
