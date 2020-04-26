package com.mike.patterns.behavioral.Command;

import com.mike.patterns.behavioral.Command.commandlogic.DeleteCommand;
import com.mike.patterns.behavioral.Command.commandlogic.InsertCommand;
import com.mike.patterns.behavioral.Command.commandlogic.SelectCommand;
import com.mike.patterns.behavioral.Command.commandlogic.UpdateCommand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;

public class Client {
    private static int lastId = 0;

    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        Connection conn = Database.getInstance();

        Developer developer = new Developer(
                new InsertCommand(database),
                new UpdateCommand(database),
                new DeleteCommand(database),
                new SelectCommand(database)
        );

        String selectQuery = "SELECT * FROM new_table";
        select(developer, selectQuery);

        lastId += 1;
        String insertQuery = "INSERT INTO new_table VALUES (" + lastId + ", 'Command pattern', 'This message was send from JDBC + Command pattern. id = " + lastId + "')";
        insert(developer, insertQuery);
        selectAll(selectQuery, developer);

        lastId += 1;
        String insertQuery2 = "INSERT INTO new_table VALUES (" + lastId + ", 'Command pattern', 'This message was send from JDBC + Command pattern. id = " + lastId + "')";
        insert(developer, insertQuery2);
        selectAll(selectQuery, developer);

        update(developer);
        selectAll(selectQuery, developer);

        String deleteQuery = "DELETE FROM new_table WHERE id = " + lastId;
        delete(developer, deleteQuery);

        // Undo delete
        List<Savepoint> allTransactions = database.getAllTransaction();
        Savepoint savepoint = allTransactions.get(allTransactions.size() - 1);
        database.undoLast(savepoint);

        // Undo update
        savepoint = allTransactions.get(allTransactions.size() - 2);
        database.undoLast(savepoint);

        conn.commit();
        conn.close();
    }

    private static void selectAll(String selectQuery, Developer developer) {
        try (ResultSet resultSet = developer.selectRecord(selectQuery);) {
            System.out.println("===============");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("header") + " - " + resultSet.getString("text"));
            }
            System.out.println("===============");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void select(Developer developer, String selectQuery) {
        try (ResultSet resultSet = developer.selectRecord(selectQuery);) {
            System.out.println("===============");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("header") + " - " + resultSet.getString("text"));
                lastId = resultSet.getInt("id");
            }
            System.out.println("===============");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(Developer developer, String insertQuery) throws SQLException {
        boolean insertResult = developer.insertRecord(insertQuery);
        if (insertResult) {
            System.out.println("New column was successfully sent");
        } else {
            System.out.println("Insert was rollback");
            lastId -= 1;
        }
    }

    private static void update(Developer developer) throws SQLException {
        String updateQuery = "UPDATE new_table SET header = 'UPDATED HEADER', text = 'New updated text :)' WHERE id = " + lastId;
        boolean isUpdated = developer.updateRecord(updateQuery);
        if (isUpdated) {
            System.out.println("ID = " + lastId + " column was successfully updated");
        } else {
            System.out.println("Update was rollback");
        }
    }

    private static void delete(Developer developer, String deleteQuery) throws SQLException {
        boolean isDeleted = developer.deleteRecord(deleteQuery);
        if (isDeleted) {
            System.out.println("ID = " + lastId + " column was successfully deleted");
        } else {
            System.out.println("Delete was rollback");
        }
    }
}
