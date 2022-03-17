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
public class AgeType implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ageId;
    private String ageType;

    public AgeType() {
    }

    public AgeType(int ageId, String ageType) {
        this.ageId = ageId;
        this.ageType = ageType;
    }

    public int getAgeId() {
        return ageId;
    }

    public void setAgeId(int ageId) {
        this.ageId = ageId;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }
}
