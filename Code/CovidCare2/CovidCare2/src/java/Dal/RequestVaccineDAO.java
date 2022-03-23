/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.PostVaccinate;
import Model.RequestVaccinate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class RequestVaccineDAO extends DBContext {

    public ArrayList<RequestVaccinate> getListRequsetVaccinate(String username) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        RequestVaccinate pr = null;
        ArrayList<RequestVaccinate> listRv = new ArrayList<>();

        try {
            String sql = "";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                pr = new RequestVaccinate();
             
                listRv.add(pr);
            }
        } catch (Exception e) {

        }
        return listRv;
    }

    public int addPostVaccinate(RequestVaccinate rv) {
        try {
            String sql = "";
            PreparedStatement stm = connection.prepareStatement(sql);
            
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

}
