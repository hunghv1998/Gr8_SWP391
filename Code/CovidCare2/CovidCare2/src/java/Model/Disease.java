/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author chinh
 */
public class Disease {
    private int diseaseId;
    private String diseaseDetail;

    public Disease() {
    }

    public Disease(int diseaseId, String diseaseDetail) {
        this.diseaseId = diseaseId;
        this.diseaseDetail = diseaseDetail;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseDetail() {
        return diseaseDetail;
    }

    public void setDiseaseDetail(String diseaseDetail) {
        this.diseaseDetail = diseaseDetail;
    }
}
