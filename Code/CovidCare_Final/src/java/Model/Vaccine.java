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
public class Vaccine implements Serializable {

    private static final long serialVersionUID = 1L;

    private int vaccId;
    private String vaccName;

    public Vaccine() {
    }

    public Vaccine(int vaccId, String vaccName) {
        this.vaccId = vaccId;
        this.vaccName = vaccName;
    }

    public int getVaccId() {
        return vaccId;
    }

    public void setVaccId(int vaccId) {
        this.vaccId = vaccId;
    }

    public String getVaccName() {
        return vaccName;
    }

    public void setVaccName(String vaccName) {
        this.vaccName = vaccName;
    }
}
