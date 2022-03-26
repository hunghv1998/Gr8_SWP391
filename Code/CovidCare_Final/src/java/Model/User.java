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
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int userId;
    private String username;
    private String password;
    private int userType;
    private boolean activeStatus;

    public User() {
    }

    public User(int userId, String username, String password, int userType, boolean activeStatus) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.activeStatus = activeStatus;
    }

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int userId, String username, int userType, boolean activeStatus) {
        this.userId = userId;
        this.username = username;
        this.userType = userType;
        this.activeStatus = activeStatus;
    }

    public User(String username, String password, int userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User(String username, String password, int userType, boolean activeStatus) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.activeStatus = activeStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", password=" + password + ", userType=" + userType + ", activeStatus=" + activeStatus + '}';
    }
    
}
