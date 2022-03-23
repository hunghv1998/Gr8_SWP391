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
    String createdBy;
    Date createdDate;
    Date startDate;
    Date expiredDate;
    String place;
    int vaccId;
    int wardId;
    int amount;
    boolean status;
    String note;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public PostVaccinate(int id, String createdBy, Date createdDate, Date startDate, Date expiredDate, String place, int vaccId, int wardId, int amount, boolean status, String note) {
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
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

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}


