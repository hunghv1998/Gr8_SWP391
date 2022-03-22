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
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userType;
    private String description;

    public UserRole() {
    }

    public UserRole(int userType, String description) {
        this.userType = userType;
        this.description = description;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
