/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PatientInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class PatientDAO extends DBContext {

    public boolean isFirstTimeLogin(int userId) {
        String sql = "SELECT firstTimeLogin FROM Patient WHERE patientId=" + userId;

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                boolean firstTimeLogin = rs.getBoolean("firstTimeLogin");
                return firstTimeLogin;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void updateFirstTimeFlag(int userId, boolean flag) {
        String sql = "UPDATE Patient SET firstTimeLogin=? WHERE patientId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setBoolean(1, flag);
            pre.setInt(2, userId);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPatient(int userId) {
        String sql = "INSERT INTO Patient(patientId) VALUES (?)";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, userId);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PatientInfo getPatientInfo(int userId) {
        String sql = "SELECT * FROM Patient WHERE patientId=" + userId;

        ResultSet rs = getData(sql);

        try {
            PatientInfo patient = new PatientInfo();

            if (rs.next()) {
                patient.setUserId(rs.getInt("patientId"));
                patient.setName(rs.getString("name"));
                patient.setBirthday(rs.getDate("birthday"));
                patient.setGender(rs.getBoolean("gender"));
                patient.setEmail(rs.getString("email"));
                patient.setAddress(rs.getString("address"));
                patient.setPhoto(rs.getString("photo"));
                patient.setWardId(rs.getString("wardId"));
                patient.setAgeType(rs.getInt("ageType"));
                patient.setCovidStatus(rs.getBoolean("covidStatus"));
                patient.setCovidPhoto(rs.getString("covidPhoto"));
                patient.setFirstTimeLogin(rs.getBoolean("firstTimeLogin"));
                patient.setVaccineStatus(rs.getInt("vaccineStatus"));
                patient.setPregnancyStatus(rs.getBoolean("pregnancyStatus"));
                patient.setEmergencyStatus(rs.getBoolean("emergencyStatus"));
                patient.setVaccList(this.getPatientVaccinesList(userId));
                patient.setDiseases(this.getPatientDiseasesList(userId));
                return patient;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updatePatientInfo(PatientInfo patient) {
        String sql = "UPDATE Patient SET "
                + "name=?, "
                + "birthday=?, "
                + "gender=?, "
                + "email=?, "
                + "address=?, "
                + "photo=?, "
                + "wardId=?, "
                + "ageType=?, "
                + "vaccineStatus=?, "
                + "pregnancyStatus=?, "
                + "emergencyStatus=? "
                + "WHERE patientId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, patient.getName());
            pre.setDate(2, patient.getBirthday());
            pre.setBoolean(3, patient.isGender());
            pre.setString(4, patient.getEmail());
            pre.setString(5, patient.getAddress());
            pre.setString(6, patient.getPhoto());
            pre.setString(7, patient.getWardId());
            pre.setInt(8, patient.getAgeType());
            pre.setInt(9, patient.getVaccineStatus());
            pre.setBoolean(10, patient.isPregnancyStatus());
            pre.setBoolean(11, patient.isEmergencyStatus());
            pre.setInt(12, patient.getUserId());

            pre.executeUpdate();
            this.updatePatientVaccines(patient.getUserId(), patient.getVaccList());
            this.updatePatientDiseases(patient.getUserId(), patient.getDiseases());
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Integer> getPatientDiseasesList(int userId) {
        String sql = "SELECT diseaseId from Patient_diseases WHERE userId=" + userId;

        ResultSet rs = getData(sql);

        ArrayList<Integer> result = new ArrayList<>();

        try {
            while (rs.next()) {
                result.add(rs.getInt("diseaseId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<Integer> getPatientVaccinesList(int userId) {
        String sql = "SELECT vaccId from Patient_Vaccines WHERE patientId=" + userId;

        ResultSet rs = getData(sql);

        ArrayList<Integer> result = new ArrayList<>();

        try {
            while (rs.next()) {
                result.add(rs.getInt("vaccId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void updatePatientDiseases(int userId, ArrayList<Integer> diseasesList) {
        String sql_update = "INSERT INTO Patient_diseases(userId, diseaseId) VALUES(?,?)";
        String sql_delete = "DELETE FROM Patient_diseases WHERE userId=?";
        try {
//            Delete previous records in Patient_diseases table
            PreparedStatement delete = connection.prepareStatement(sql_delete);
            delete.setInt(1, userId);
            delete.executeUpdate();

//            Update new records into Patient_diseases table
            for (int i = 0; i < diseasesList.size(); i++) {
                PreparedStatement update = connection.prepareStatement(sql_update);
                update.setInt(1, userId);
                update.setInt(2, diseasesList.get(i));
                update.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePatientVaccines(int userId, ArrayList<Integer> vaccinesList) {
        String sql_update = "INSERT INTO Patient_Vaccines(patientId,vaccId) VALUES (?,?)";
        String sql_delete = "DELETE FROM Patient_Vaccines WHERE patientId=?";
        try {
//            Delete previous records in Patient_diseases table
            PreparedStatement delete = connection.prepareStatement(sql_delete);
            delete.setInt(1, userId);
            delete.executeUpdate();

//            Update new records into Patient_diseases table
            for (int i = 0; i < vaccinesList.size(); i++) {
                PreparedStatement update = connection.prepareStatement(sql_update);
                update.setInt(1, userId);
                update.setInt(2, vaccinesList.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCovidStatus(int UserId, boolean covidStatus) {
        String sql = "UPDATE Patient SET covidStatus =? WHERE userId=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setBoolean(1, covidStatus);
            pre.setInt(2, UserId);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCovidPhoto(int UserId, String CovidPhoto) {
        String sql = "UPDATE Patient SET covidPhoto=? WHERE userId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, CovidPhoto);
            pre.setInt(2, UserId);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
