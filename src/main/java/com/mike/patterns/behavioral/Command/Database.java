package com.mike.patterns.behavioral.Command;

import java.sql.*;

import static java.sql.Connection.TRANSACTION_SERIALIZABLE;

public class Database {
    private static final String USERNAME = "<your_username>";
    private static final String PASSWORD = "<your_password>";
    private static final String URL = "<your_url_to_db>";
    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setTransactionIsolation(TRANSACTION_SERIALIZABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insert(String query) {
        System.out.println("Insert");
        return executeUpdateInsertDelete(query);
    }

    public boolean update(String query) {
        System.out.println("Update");
        return executeUpdateInsertDelete(query);
    }

    public boolean delete(String query) {
        System.out.println("Delete");
        return executeUpdateInsertDelete(query);
    }

    public ResultSet select(String query) {
        System.out.println("Select");
        try {
            if (!isConnectionNull()) {
                Statement statement = connection.createStatement();
                return statement.executeQuery(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isConnectionNull() {
        return connection == null;
    }

    private boolean executeUpdateInsertDelete(String query) {
        try {
            if (!isConnectionNull()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
