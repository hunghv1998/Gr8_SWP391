/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class DBContext {
    protected Connection connection;

    public DBContext(String URL, String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Connected!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public DBContext() {
        this("jdbc:sqlserver://localhost:1433;databaseName=CovidCareDB;sslProtocol=TLSv1.2;", "sa", "123456");
    }

    public static void main(String[] args) {
        new DBContext();
    }

    public Connection getConnection() {
        return connection;
    }
}
