/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.News;
import Model.NewsCategory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class NewsDAO extends DBContext {

    public News getNewsById(int id) {
        String sql = "SELECT * FROM News WHERE id=" + id;

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                News news = new News();

                news.setNewsId(rs.getInt("id"));
                news.setCreator(rs.getInt("creator"));
                news.setCateId(rs.getInt("cateId"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setShort_des(rs.getString("description"));
                news.setPhoto(rs.getString("photo"));
                news.setStatus(rs.getBoolean("status"));
                news.setCreate_date(rs.getTimestamp("create_date"));
                news.setPublish_date(rs.getTimestamp("publish_date"));
                news.setReadCount(rs.getInt("readCount"));

                return news;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public News getNewsForReader(int id) {
        String sql = "SELECT * FROM News WHERE id=" + id + " AND status=1";

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                News news = new News();

                news.setNewsId(rs.getInt("id"));
                news.setCreator(rs.getInt("creator"));
                news.setCateId(rs.getInt("cateId"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setShort_des(rs.getString("description"));
                news.setPhoto(rs.getString("photo"));
                news.setStatus(rs.getBoolean("status"));
                news.setCreate_date(rs.getTimestamp("create_date"));
                news.setPublish_date(rs.getTimestamp("publish_date"));
                news.setReadCount(rs.getInt("readCount"));

                return news;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<News> getNewsListByCategoryId(int cateId) {
        String sql = "SELECT * FROM News WHERE cateId=" + cateId + " AND status=1";

        ResultSet rs = getData(sql);

        try {
            ArrayList<News> newsList = new ArrayList<>();
            while (rs.next()) {
                News news = new News();

                news.setNewsId(rs.getInt("id"));
                news.setCreator(rs.getInt("creator"));
                news.setCateId(rs.getInt("cateId"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setShort_des(rs.getString("description"));
                news.setPhoto(rs.getString("photo"));
                news.setStatus(rs.getBoolean("status"));
                news.setCreate_date(rs.getTimestamp("create_date"));
                news.setPublish_date(rs.getTimestamp("publish_date"));
                news.setReadCount(rs.getInt("readCount"));

                newsList.add(news);
            }
            return newsList;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int addNews(News news) {
        String sql = "INSERT INTO News"
                + "(creator, cateId, title, content, description, "
                + "photo, status, create_date, publish_date, readCount) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, news.getCreator());
            pre.setInt(2, news.getCateId());
            pre.setString(3, news.getTitle());
            pre.setString(4, news.getContent());
            pre.setString(5, news.getShort_des());
            pre.setString(6, news.getPhoto());
            pre.setBoolean(7, news.isStatus());
            pre.setTimestamp(8, news.getCreate_date());
            pre.setTimestamp(9, news.getPublish_date());
            pre.setInt(10, news.getReadCount());

            return (pre.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int updateNews(News news) {
        String sql = "UPDATE News SET "
                + "creator=?, "
                + "cateId=?, "
                + "title=?, "
                + "content=?, "
                + "description=?, "
                + "photo=?, "
                + "status=?, "
                + "create_date=?, "
                + "publish_date=? WHERE id=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, news.getCreator());
            pre.setInt(2, news.getCateId());
            pre.setString(3, news.getTitle());
            pre.setString(4, news.getContent());
            pre.setString(5, news.getShort_des());
            pre.setString(6, news.getPhoto());
            pre.setBoolean(7, news.isStatus());
            pre.setTimestamp(8, news.getCreate_date());
            pre.setTimestamp(9, news.getPublish_date());
            pre.setInt(10, news.getNewsId());

            return (pre.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public NewsCategory getCategoryById(int cateId) {
        String sql = "SELECT * FROM NewsCategory WHERE id=" + cateId;

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                NewsCategory cate = new NewsCategory();

                cate.setCateId(rs.getInt("id"));
                cate.setCateName(rs.getString("description"));

                return cate;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList<News> searchNews(String searchText, int searchCate) {
        String sql1 = "SELECT * FROM News WHERE";
        String sql2 = " title like '%" + searchText + "%'";
        String sql3 = " cateId=" + searchCate;

        if ((searchText != null || !searchText.equals("")) && searchCate > 0) {
            sql1 = sql1 + sql2 + " AND" + sql3;
        } else if ((searchText == null || searchText.equals("")) && searchCate > 0) {
            sql1 = sql1 + sql3;
        } else {
            sql1 = sql1 + sql2;
        }
        ResultSet rs = getData(sql1);

        ArrayList<News> newsList = new ArrayList<>();

        try {
            while (rs.next()) {
                News news = new News();

                news.setNewsId(rs.getInt("id"));
                news.setCreator(rs.getInt("creator"));
                news.setCateId(rs.getInt("cateId"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setShort_des(rs.getString("description"));
                news.setPhoto(rs.getString("photo"));
                news.setStatus(rs.getBoolean("status"));
                news.setCreate_date(rs.getTimestamp("create_date"));
                news.setPublish_date(rs.getTimestamp("publish_date"));
                news.setReadCount(rs.getInt("readCount"));
                newsList.add(news);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newsList;
    }

    public ArrayList<NewsCategory> getCateList() {
        String sql = "SELECT * FROM NewsCategory";

        ResultSet rs = getData(sql);

        try {
            ArrayList<NewsCategory> cateList = new ArrayList<>();

            while (rs.next()) {
                NewsCategory cate = new NewsCategory();

                cate.setCateId(rs.getInt("id"));
                cate.setCateName(rs.getString("description"));

                cateList.add(cate);
            }
            return cateList;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void hideNews(int newsId) {
        String sql = "UPDATE News SET status=0 WHERE id=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setInt(1, newsId);

            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showNews(int newsId) {
        String sql = "UPDATE News SET status=1 WHERE id=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setInt(1, newsId);

            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<News> getAllNews() {
        String sql = "SELECT * FROM News";

        ArrayList<News> newsList = new ArrayList<>();

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                News news = new News();

                news.setNewsId(rs.getInt("id"));
                news.setCreator(rs.getInt("creator"));
                news.setCateId(rs.getInt("cateId"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setShort_des(rs.getString("description"));
                news.setPhoto(rs.getString("photo"));
                news.setStatus(rs.getBoolean("status"));
                news.setCreate_date(rs.getTimestamp("create_date"));
                news.setPublish_date(rs.getTimestamp("publish_date"));
                news.setReadCount(rs.getInt("readCount"));
                newsList.add(news);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newsList;
    }

    public String getCateName(int id) {
        String sql = "SELECT description from NewsCategory WHERE id=" + id;

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                return (rs.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public ArrayList<News> getTopNewsByCategoryId() {
        ArrayList<NewsCategory> cateList = getCateList();

        ArrayList<News> newsList = new ArrayList<>();

        for (int i = 0; i < cateList.size(); i++) {
            String sql = "SELECT TOP 4 * FROM News WHERE cateId= " + cateList.get(i).getCateId() + " AND status=1 ORDER BY publish_date DESC";

            ResultSet rs = getData(sql);

            try {
                while (rs.next()) {
                    News news = new News();

                    news.setNewsId(rs.getInt("id"));
                    news.setCreator(rs.getInt("creator"));
                    news.setCateId(rs.getInt("cateId"));
                    news.setTitle(rs.getString("title"));
                    news.setContent(rs.getString("content"));
                    news.setShort_des(rs.getString("description"));
                    news.setPhoto(rs.getString("photo"));
                    news.setStatus(rs.getBoolean("status"));
                    news.setCreate_date(rs.getTimestamp("create_date"));
                    news.setPublish_date(rs.getTimestamp("publish_date"));
                    news.setReadCount(rs.getInt("readCount"));
                    newsList.add(news);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newsList;
    }

    public void updateReadCount(int id) {
        String sql = "UPDATE News "
                + "SET readCount = readCount + 1 "
                + "WHERE id=" + id;

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
