package com.mike.patterns.behavioral.Command;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String USERNAME = "<your_username>";
    private static final String PASSWORD = "<your_password>";
    private static final String URL = "<your_url_to_db>";
    private static Connection connection = null;

    private static int countDeleteTransactions = 0;
    private static int countSelectTransactions = 0;
    private static int countInsertTransactions = 0;
    private static int countUpdateTransactions = 0;

    private final List<Savepoint> lastTransaction = new ArrayList<>();

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // ! Important line
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insert(String query) throws SQLException {
        System.out.println("Insert");
        countInsertTransactions++;
        Savepoint savePointInsert = connection.setSavepoint("InsertSavePoint" + countInsertTransactions);
        lastTransaction.add(savePointInsert);
        return executeUpdateInsertDelete(query, savePointInsert);
    }

    public boolean update(String query) throws SQLException {
        System.out.println("Update");
        countUpdateTransactions++;
        Savepoint savePointUpdate = connection.setSavepoint("UpdateSavePoint" + countUpdateTransactions);
        lastTransaction.add(savePointUpdate);
        return executeUpdateInsertDelete(query, savePointUpdate);
    }

    public boolean delete(String query) throws SQLException {
        System.out.println("Delete");
        countDeleteTransactions++;
        Savepoint savePointDelete = connection.setSavepoint("DeleteSavePoint" + countDeleteTransactions);
        lastTransaction.add(savePointDelete);
        return executeUpdateInsertDelete(query, savePointDelete);
    }

    public ResultSet select(String query) throws SQLException {
        System.out.println("Select");
        countSelectTransactions++;
        Savepoint savePointSelect = connection.setSavepoint("SelectSavePoint" + countSelectTransactions);
        lastTransaction.add(savePointSelect);
        try {
            if (isConnectionNotNull()) {
                Statement statement = connection.createStatement();
                return statement.executeQuery(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback(savePointSelect);
        }
        return null;
    }

    private boolean isConnectionNotNull() {
        return connection != null;
    }

    private boolean executeUpdateInsertDelete(String query, Savepoint savePoint) throws SQLException {
        try {
            if (isConnectionNotNull()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback(savePoint);
        }
        return false;
    }

    public static Connection getInstance() {
        return connection;
    }

    public void undoLast(Savepoint savepoint) throws SQLException {
        lastTransaction.remove(savepoint);
        connection.rollback(savepoint);
    }

    public List<Savepoint> getAllTransaction() {
        return lastTransaction;
    }
}
