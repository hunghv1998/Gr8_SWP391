/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author chinh
 */
public class News {
    private static final long serialVersionUID = 1L;
    
    private int newsId;
    private String content;
    private String uname;
    private String title;
    private String short_des;
    private Date create_date;
    private Date publish_date;
    private String photo;

    public News() {
    }

    public News(int newsId, String content, String uname, String title, String short_des, Date create_date, Date publish_date, String photo) {
        this.newsId = newsId;
        this.content = content;
        this.uname = uname;
        this.title = title;
        this.short_des = short_des;
        this.create_date = create_date;
        this.publish_date = publish_date;
        this.photo = photo;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_des() {
        return short_des;
    }

    public void setShort_des(String short_des) {
        this.short_des = short_des;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    

    
}
