/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.News;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class NewsDAO extends DBContext {

    public int createNews(News news) {
        int n = 0;

        String sql = "INSERT INTO news(content, uname, title, short_des, created_date) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, news.getContent());
            pre.setString(2, news.getUname());
            pre.setString(3, news.getTitle());
            pre.setString(4, news.getShort_des());
            pre.setDate(5, news.getCreate_date());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public News getNews(int id) {
        String sql = "SELECT * FROM news WHERE newsId=" + id;
        ResultSet rs = getData(sql);
        try {
            if (rs.next()) {
                int newsId = rs.getInt(1);
                String content = rs.getString(2);
                String uname = rs.getString(3);
                String title = rs.getString(4);
                String short_des = rs.getString(5);
                Date create_date = rs.getDate(6);
                Date publish_date = rs.getDate(7);
                String photo = rs.getString(8);
                
                News news = new News(newsId, content, uname, title, short_des, create_date, publish_date, photo);
                return news;
            }
        } catch (SQLException ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    public ArrayList<News> getAll() {
        ArrayList<News> arr = new ArrayList<>();

        String sql = "SELECT * FROM news";
        ResultSet rs = getData(sql);
        
        try {
            while ((rs.next())) {
                int newsId = rs.getInt(1);
                String content = rs.getString(2);
                String uname = rs.getString(3);
                String title = rs.getString(4);
                String short_des = rs.getString(5);
                Date create_date = rs.getDate(6);
                Date publish_date = rs.getDate(7);
                String photo = rs.getString(8);
                
                News news = new News(newsId, content, uname, title, short_des, create_date, publish_date, photo);
                arr.add(news);
            }
        } catch (SQLException ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }
    
    public List<News> paging(int index) {
        ArrayList<News> arr = new ArrayList<>();

        String sql = "SELECT * FROM news order by newsId OFFSET\n" +
"				? ROWS  FETCH NEXT 2 ROWS ONLY";
        ResultSet rs = getData(sql);
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index * 2 - 2));
            rs = ps.executeQuery();
            while ((rs.next())) {
                int newsId = rs.getInt(1);
                String content = rs.getString(2);
                String uname = rs.getString(3);
                String title = rs.getString(4);
                String short_des = rs.getString(5);
                Date create_date = rs.getDate(6);
                Date publish_date = rs.getDate(7);
                String photo = rs.getString(8);
                
                News news = new News(newsId, content, uname, title, short_des, create_date, publish_date, photo);
                arr.add(news);
            }
        } catch (SQLException ex) {
            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }
    
    public int totalPage() {
        int total = 0;
        String sql = "select count(*)\n"
                + "from News";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int totalA = rs.getInt(1);
                total = totalA / 2;
                if (totalA % 2 != 0) {
                    total++;
                }
            }
        } catch (Exception e) {
        }
        return total;
    }
 }
