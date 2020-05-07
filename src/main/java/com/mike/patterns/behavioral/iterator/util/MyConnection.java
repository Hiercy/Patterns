package com.mike.patterns.behavioral.iterator.util;


import java.sql.*;

public class MyConnection {
    private static final String USERNAME = "<your_username>";
    private static final String PASSWORD = "<your_password>";
    private static final String URL = "<your_url>";
    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet select(String query) {
        try {
            if (isConnectionNotNull()) {
                Statement statement = connection.createStatement();
                return statement.executeQuery(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(String query) {
        return executeUpdateInsertDelete(query);
    }

    public boolean update(String query) {
        return executeUpdateInsertDelete(query);
    }

    public boolean delete(String query) {
        return executeUpdateInsertDelete(query);
    }

    private boolean executeUpdateInsertDelete(String query) {
        try {
            if (isConnectionNotNull()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isConnectionNotNull() {
        return connection != null;
    }
}
