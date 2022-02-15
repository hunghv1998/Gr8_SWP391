/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author chinh
 */
public class UserInfo {
    private int userId;
    private Date bday;
    private boolean sex;
    private String email;
    private String image;
    private String address;
    private String name;
    private boolean firstTimeLogin;
    private String uname;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public UserInfo(int userId, Date bday, boolean sex, String email, String image, String address, String name, boolean firstTimeLogin, String uname) {
        this.userId = userId;
        this.bday = bday;
        this.sex = sex;
        this.email = email;
        this.image = image;
        this.address = address;
        this.name = name;
        this.firstTimeLogin = firstTimeLogin;
        this.uname = uname;
    }

    public UserInfo(Date bday, boolean sex, String email, String image, String address, String name) {
        this.bday = bday;
        this.sex = sex;
        this.email = email;
        this.image = image;
        this.address = address;
        this.name = name;
    }
}
