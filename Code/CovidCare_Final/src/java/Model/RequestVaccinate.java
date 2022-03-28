/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class RequestVaccinate {
    int id;
    int created_by;
    String created_name;

    public String getCreated_name() {
        return created_name;
    }

    public void setCreated_name(String created_name) {
        this.created_name = created_name;
    }
    String created_date;
    String phone;
    String status;
    String note;
    String image;

    public RequestVaccinate() {
    }

    public RequestVaccinate(int id, int created_by, String created_date, String phone, String status, String note, String image) {
        this.id = id;
        this.created_by = created_by;
        this.created_date = created_date;
        this.phone = phone;
        this.status = status;
        this.note = note;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RequestVaccinate{" + "id=" + id + ", created_by=" + created_by + ", created_date=" + created_date + ", phone=" + phone + ", status=" + status + ", note=" + note + ", image=" + image + '}';
    }
    
    
    
    
    
    
}
