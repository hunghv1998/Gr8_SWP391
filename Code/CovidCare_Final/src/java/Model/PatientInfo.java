/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author chinh
 */
public class PatientInfo {

    private int userId;
    private String name;
    private Date birthday;
    private boolean gender;
    private String email;
    private String address;
    private String photo;
    private int wardId;
    private int ageType;
    private ArrayList<Disease> diseases;
    private boolean firstTimeLogin;

    public PatientInfo() {
    }

    public PatientInfo(int userId, String name, Date birthday, boolean gender, String email, String address, String photo, int wardId, int ageType, ArrayList<Disease> diseases, boolean firstTimeLogin) {
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
        this.firstTimeLogin = firstTimeLogin;
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

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public int getAgeType() {
        return ageType;
    }

    public void setAgeType(int ageType) {
        this.ageType = ageType;
    }

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(ArrayList<Disease> diseases) {
        this.diseases = diseases;
    }

    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

}
