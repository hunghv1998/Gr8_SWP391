/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.NewsCategories;
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
public class NewsCategoriesDAO extends DBContext {

    public int insertCategory(NewsCategories cate) {
        int n = 0;

        String sql = "INSERT INTO news_categories(categoryName) values(?)";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsCategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCategory(NewsCategories cate, int i) {
        int n = 0;
        String sql = "UPDATE news_categories SET categoryName=? where categoryId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setInt(2, i);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsCategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public NewsCategories getCategory(int id) {
        String sql = "SELECT * FROM news_categories WHERE categoryId = " + id;

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                NewsCategories category = new NewsCategories(rs.getInt(1), rs.getString(2));
                return category;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsCategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<NewsCategories> searchCategory(String cateName) {
        ArrayList<NewsCategories> arr = new ArrayList<>();

        String sql = "SELECT * FROM news_categories WHERE categoryName like '%" + cateName + "%'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                arr.add(new NewsCategories(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsCategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

    public ArrayList<NewsCategories> getAll() {
        ArrayList<NewsCategories> arr = new ArrayList<>();

        String sql = "SELECT * FROM news_categories";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                arr.add(new NewsCategories(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsCategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

    public int removeCategory(int id) {
        int n = 0;
        String sql = "DELETE FROM news_categories where categoryId=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsCategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
