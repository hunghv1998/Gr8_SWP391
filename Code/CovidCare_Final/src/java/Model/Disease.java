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
public class Disease implements Serializable {

    private static final long serialVersionUID = 1L;

    private int diseaseId;
    private String detail;

    public Disease() {
    }

    public Disease(int diseaseId, String detail) {
        this.diseaseId = diseaseId;
        this.detail = detail;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
