/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author chinh
 */
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userId;
    private String name;
    private Date birthday;
    private boolean gender;
    private String email;
    private String address;
    private String photo;
    private String wardId;
    private int ageType;
    private ArrayList<Integer> diseases;
    private boolean covidStatus;
    private String covidPhoto;
    private boolean firstTimeLogin;
    private int vaccineStatus;
    private boolean pregnancyStatus;
    private boolean emergencyStatus;
    private ArrayList<Integer> vaccList;

    public Patient() {
    }

    public Patient(int userId, boolean covidStatus, String covidPhoto) {
        this.userId = userId;
        this.covidStatus = covidStatus;
        this.covidPhoto = covidPhoto;
    }

    public Patient(int userId, String name, Date birthday, boolean gender, String email, String address, String photo, String wardId, int ageType, ArrayList<Integer> diseases, boolean covidStatus, String covidPhoto, boolean firstTimeLogin, int vaccineStatus, boolean pregnancyStatus, boolean emergencyStatus, ArrayList<Integer> vaccList) {
        this.userId = userId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.photo = photo;
        this.wardId = wardId;
        this.ageType = ageType;
        this.diseases = diseases;
        this.covidStatus = covidStatus;
        this.covidPhoto = covidPhoto;
        this.firstTimeLogin = firstTimeLogin;
        this.vaccineStatus = vaccineStatus;
        this.pregnancyStatus = pregnancyStatus;
        this.emergencyStatus = emergencyStatus;
        this.vaccList = vaccList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public int getAgeType() {
        return ageType;
    }

    public void setAgeType(int ageType) {
        this.ageType = ageType;
    }

    public ArrayList<Integer> getDiseases() {
        return diseases;
    }

    public void setDiseases(ArrayList<Integer> diseases) {
        this.diseases = diseases;
    }

    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public boolean isCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(boolean covidStatus) {
        this.covidStatus = covidStatus;
    }

    public String getCovidPhoto() {
        return covidPhoto;
    }

    public void setCovidPhoto(String covidPhoto) {
        this.covidPhoto = covidPhoto;
    }

    public int getVaccineStatus() {
        return vaccineStatus;
    }

    public void setVaccineStatus(int vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }

    public boolean isPregnancyStatus() {
        return pregnancyStatus;
    }

    public void setPregnancyStatus(boolean pregnancyStatus) {
        this.pregnancyStatus = pregnancyStatus;
    }

    public boolean isEmergencyStatus() {
        return emergencyStatus;
    }

    public void setEmergencyStatus(boolean emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
    }

    public ArrayList<Integer> getVaccList() {
        return vaccList;
    }

    public void setVaccList(ArrayList<Integer> vaccList) {
        this.vaccList = vaccList;
    }

}
