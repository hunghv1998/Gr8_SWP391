/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AgeType;
import Model.City;
import Model.Disease;
import Model.District;
import Model.Vaccine;
import Model.VaccineStatus;
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

    public ArrayList<VaccineStatus> getVaccineStatusList() {
        ArrayList<VaccineStatus> statusList = new ArrayList<>();
        String sql = "SELECT * FROM VaccineStatus";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String detail = rs.getString(2);
                statusList.add(new VaccineStatus(id, detail));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statusList;
    }

    public ArrayList<Vaccine> getVaccineList() {
        ArrayList<Vaccine> vaccines = new ArrayList<>();
        String sql = "SELECT * FROM Vaccines";

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
        String sql = "SELECT * FROM AgeTypes";

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
        String sql = "SELECT * FROM Diseases";

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
        String sql = "SELECT * FROM Cities";

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
        String sql = "SELECT * FROM Districts WHERE cityId='" + id + "'";

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
        String sql = "SELECT * FROM Wards WHERE districtId='" + id + "'";

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

    public City geCityByWardId(String id) {
        String sql = "SELECT cdw.cityId, cdw.cityName FROM ("
                + "SELECT c.cityId, c.cityName, dw.districtId, dw.districtName, dw.wardId, dw.wardName \n"
                + "FROM Cities c \n"
                + "JOIN (\n"
                + "SELECT d.districtId, d.districtName, d.cityId, w.wardId, w.wardName \n"
                + "FROM Wards w \n"
                + "JOIN Districts d \n"
                + "ON d.districtId = w.districtId) dw \n"
                + "ON c.cityId = dw.cityId) cdw \n"
                + "WHERE cdw.wardId='" + id + "'";
        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                City city = new City();
                city.setCityId(rs.getString(1));
                city.setCityName(rs.getString(2));
                return city;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public District getDistrictByWardId(String id) {
        String sql = "SELECT d.districtId, d.districtName, d.cityId \n"
                + "FROM Districts d\n"
                + "JOIN Wards w\n"
                + "ON d.districtId = w.districtId\n"
                + "WHERE w.wardId='" + id + "'";
        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                District district = new District();
                district.setDistrictId(rs.getString(1));
                district.setDistrictName(rs.getString(2));
                district.setCityId(rs.getString(3));
                return district;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Ward getWardByWardId(String id) {
        String sql = "SELECT wardId, wardName FROM Wards WHERE wardId='" + id + "'";
        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                Ward ward = new Ward();
                ward.setWardId(rs.getString(1));
                ward.setWardName(rs.getString(2));
                return ward;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
