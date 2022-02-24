/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.AgeType;
import Model.City;
import Model.Disease;
import Model.District;
import Model.Vaccine;
import Model.Ward;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class CommonDataDAO extends DBContext {

    public ArrayList<Vaccine> getVaccineList() {
        ArrayList<Vaccine> vaccines = new ArrayList<>();
        String sql = "SELECT * FROM Vaccine";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int vaccId = rs.getInt(1);
                String vaccName = rs.getString(2);
                vaccines.add(new Vaccine(vaccId, vaccName));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vaccines;
    }

    public ArrayList<AgeType> getAgeTypeList() {
        ArrayList<AgeType> ages = new ArrayList<>();
        String sql = "SELECT * FROM AgeType";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int ageId = rs.getInt(1);
                String ageType = rs.getString(2);
                ages.add(new AgeType(ageId, ageType));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ages;
    }

    public ArrayList<Disease> getDiseaseList() {
        ArrayList<Disease> diseases = new ArrayList<>();
        String sql = "SELECT * FROM Disease";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int diseaseId = rs.getInt(1);
                String diseaseDetail = rs.getString(2);
                diseases.add(new Disease(diseaseId, diseaseDetail));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diseases;
    }
    
    public ArrayList<City> getAllCity() {
        ArrayList<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM cities";
        
        ResultSet rs = getData(sql);
        
        try {
            while (rs.next()) {
                String cityId = rs.getString(1);
                String cityName = rs.getString(2);
                cities.add(new City(cityId, cityName));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }
    
    public ArrayList<District> getDistrictByCityId(String id) {
        ArrayList<District> districts = new ArrayList<>();
        String sql = "SELECT * FROM districts WHERE cityId='" + id + "'";
        
        ResultSet rs = getData(sql);
        
        try {
            while (rs.next()) {
                String districtId = rs.getString(1);
                String districtName = rs.getString(2);
                String cityId = rs.getString(3);
                districts.add(new District(districtId, districtName, cityId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return districts;
    }
    
    public ArrayList<Ward> getWardByDistrictId(String id) {
        ArrayList<Ward> wards = new ArrayList<>();
        String sql = "SELECT * FROM wards WHERE districtId='" + id + "'";
        
        ResultSet rs = getData(sql);
        
        try {
            while (rs.next()) {
                String wardsId = rs.getString(1);
                String wardsName = rs.getString(2);
                String districtId = rs.getString(3);
                wards.add(new Ward(wardsId, wardsName, districtId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wards;
    }
}
