/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class PostVaccinate {
    int id;
    int createdBy;
    String createdDate;
    String startDate;
    String expiredDate;
    String place;
    int vaccId;
    String wardId;
    int amount;
    boolean status;
    String note;
    String vaccName;

    public String getVaccName() {
        return vaccName;
    }

    public void setVaccName(String vaccName) {
        this.vaccName = vaccName;
    }

    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    

    public PostVaccinate() {
    }

    @Override
    public String toString() {
        return "PostVaccinate{" + "id=" + id + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", startDate=" + startDate + ", expiredDate=" + expiredDate + ", place=" + place + ", vaccId=" + vaccId + ", wardId=" + wardId + ", amount=" + amount + ", status=" + status + ", note=" + note + '}';
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public PostVaccinate(int id, int createdBy, String createdDate, String startDate, String expiredDate, String place, int vaccId, String wardId, int amount, boolean status, String note) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.expiredDate = expiredDate;
        this.place = place;
        this.vaccId = vaccId;
        this.wardId = wardId;
        this.amount = amount;
        this.status = status;
        this.note = note;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getVaccId() {
        return vaccId;
    }

    public void setVaccId(int vaccId) {
        this.vaccId = vaccId;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}


