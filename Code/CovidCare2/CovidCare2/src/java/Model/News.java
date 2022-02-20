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
    private int newsId;
    private String content;
    private String uname;
    private String title;
    private Date create_date;
    private Date publish_date;
    private boolean status;
    private int categoryId;

    public News() {
    }

    public News(String content, String uname, String title, Date create_date, Date publish_date, boolean status, int categoryId) {
        this.content = content;
        this.uname = uname;
        this.title = title;
        this.create_date = create_date;
        this.publish_date = publish_date;
        this.status = status;
        this.categoryId = categoryId;
    }

    public News(String content, String uname, String title, Date create_date, boolean status, int categoryId) {
        this.content = content;
        this.uname = uname;
        this.title = title;
        this.create_date = create_date;
        this.status = status;
        this.categoryId = categoryId;
    }
    
    public News(int newsId, String content, String uname, String title, Date create_date, Date publish_date, boolean status, int categoryId) {
        this.newsId = newsId;
        this.content = content;
        this.uname = uname;
        this.title = title;
        this.create_date = create_date;
        this.publish_date = publish_date;
        this.status = status;
        this.categoryId = categoryId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}
