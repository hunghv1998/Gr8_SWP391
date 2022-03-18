/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Hospital;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class HospitalDAO extends DBContext {

    public void insertHospital(Hospital hospital) {

    }

    public void updateHospital(Hospital hospital) {

    }

    public Hospital getHospitalById(int userId) {
        String sql = "SELECT * FROM Hospital WHERE userId=" + userId;

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                Hospital hospital = new Hospital();

                hospital.setUserId(rs.getInt("userId"));
                hospital.setHospitalName(rs.getString("name"));
                hospital.setPhoto(rs.getString("photo"));
                hospital.setAddress(rs.getString("address"));
                hospital.setWardId(rs.getString("wardId"));

                return hospital;
            }
        } catch (SQLException ex) {

        }
        return null;
    }
}
