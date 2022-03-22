/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author chinh
 */
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int userId;
    private String hospitalName;
    private String photo;
    private String address;
    private String wardId;

    public Hospital() {
    }

    public Hospital(int userId, String hospitalName, String photo, String address, String wardId) {
        this.userId = userId;
        this.hospitalName = hospitalName;
        this.photo = photo;
        this.address = address;
        this.wardId = wardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

}
