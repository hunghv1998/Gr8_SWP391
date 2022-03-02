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
    
//    public int updateNews(News news) {
//        int n = 0;
//
//        String sql = "UPDATE news SET content=?, title=?, categoryId=? WHERE newsId=?";
//
//        try {
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setString(1, news.getContent());
//            pre.setString(2, news.getTitle());
//            pre.setInt(3, news.getCategoryId());
//            pre.setInt(4, news.getNewsId());
//
//            n = pre.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }

//    public ArrayList<News> searchNewsList(int cate, String searchText) {
//        ArrayList<News> arr = new ArrayList<>();
//
//        String sql1 = "";
//        String sql2 = "SELECT * FROM News WHERE status = 1 ";
//        String sql3 = " AND ";
//        String sql4 = "";
//        String sql5 = "";
//
//        if (cate > 0) {
//            sql4 = "categoryId = " + cate;
//        }
//        if (!searchText.isEmpty()) {
//            sql5 = "title like '%" + searchText + "%'";
//        }
//        if (cate > 0 && !searchText.isEmpty()) {
//            sql1 = sql2 + sql3 + sql4 + sql3 + sql5;
//        }
//        if (cate > 0 && searchText.isEmpty()) {
//            sql1 = sql2 + sql3 + sql4;
//        }
//        if (cate <= 0 && !searchText.isEmpty()) {
//            sql1 = sql2 + sql3 + sql5;
//        }
//        if (cate <= 0 && searchText.isEmpty()) {
//            sql1 = sql2;
//        }
//        ResultSet rs = getData(sql1);
//
//        try {
//            while ((rs.next())) {
//                int newsId = rs.getInt(1);
//                String content = rs.getString(2);
//                String uname = rs.getString(3);
//                String title = rs.getString(4);
//                Date create_date = rs.getDate(5);
//                Date publish_date = rs.getDate(6);
//                boolean status = rs.getBoolean(7);
//                int categodyId = rs.getInt(8);
//
//                News news = new News(newsId, content, uname, title, create_date, publish_date, status, categodyId);
//                arr.add(news);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return arr;
//    }

//    public int deleteNews(int id) {
//        int n = 0;
//
//        String sql = "DELETE FROM news WHERE newsId=?";
//
//        try {
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setInt(1, id);
//            n = pre.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }

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
//
//    public int updateStatus(int id, boolean status) {
//        int n = 0;
//        String sql = "UPDATE news SET status = ? WHERE newsId=?";
//        
//        try {
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setBoolean(1, status);
//            pre.setInt(2, id);
//            n = pre.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }

//    public int publishNews(int id) {
//        int n = 0;
//        String sql = "UPDATE news SET public_date = CURRENT_TIMESTAMP WHERE newsId=?";
//        
//        try {
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setInt(1, id);
//            n = pre.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(News.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }
//    
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
}
