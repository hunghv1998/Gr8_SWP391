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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class DBPool {

    private String databaseUrl = "jdbc:sqlserver://localhost:1433;databaseName=CovidCareDB;sslProtocol=TLSv1.2;";
    private String username = "sa";
    private String password = "123456";

    protected Connection connection;

    Vector connectionPool = new Vector();

    public Connection getConnection() {
        return this.connection;
    }

    public DBPool() {
        initialize();
    }

    public DBPool(String databaseUrl, String username, String password) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
    }

    private void initialize() {
        initializeConnectionPool();
    }

    private void initializeConnectionPool() {
        while (!checkIfConnectionPoolIsFull()) {
            System.out.println("Connection Pool is not full. Proceeding with adding new connections");
            connectionPool.addElement(createNewConnectionForPool());
        }
        System.out.println("Connection Pool is full.");
    }

    private synchronized boolean checkIfConnectionPoolIsFull() {
        final int MAX_POOL_SIZE = 10000;

        // Check if the pool size
        if (connectionPool.size() < MAX_POOL_SIZE) {
            return false;
        }
        return true;
    }

    private Connection createNewConnectionForPool() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(databaseUrl, username, password);
            System.out.println("Connection: " + connection);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundExcepion: ex");
            return null;
        }
        return connection;
    }

    public synchronized Connection getConnectionFromPool() {
        // Check if there is a connection available. There are times when all the connections
        // in the pool may be used up
        if (connectionPool.size() > 0) {
            connection = (Connection) connectionPool.firstElement();
            connectionPool.removeElementAt(0);
        }
        // Giving away the connection from the connection pool
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection) {
        // Adding the connection from the client back to the connection pool
        connectionPool.addElement(connection);
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static void main(String[] args) {
        DBPool dbPoolManager = new DBPool();
    }
}
