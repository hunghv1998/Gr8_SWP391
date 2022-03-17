/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author chinh
 */
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private int newsId;
    private int creator;
    private int cateId;
    private String title;
    private String content;
    private String short_des;
    private String photo;
    private boolean status;
    private Timestamp create_date;
    private Timestamp publish_date;
    private int readCount;

    public News() {
    }

    public News(int creator, String title, String content, String photo) {
        this.creator = creator;
        this.title = title;
        this.content = content;
        this.photo = photo;
    }

    public News(int newsId, int creator, int cateId, String title, String content, String short_des, String photo, boolean status, Timestamp create_date, Timestamp publish_date, int readCount) {
        this.newsId = newsId;
        this.creator = creator;
        this.cateId = cateId;
        this.title = title;
        this.content = content;
        this.short_des = short_des;
        this.photo = photo;
        this.status = status;
        this.create_date = create_date;
        this.publish_date = publish_date;
        this.readCount = readCount;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShort_des() {
        return short_des;
    }

    public void setShort_des(String short_des) {
        this.short_des = short_des;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Timestamp publish_date) {
        this.publish_date = publish_date;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

}
