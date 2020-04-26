package com.mike.patterns.behavioral.Command;

import com.mike.patterns.behavioral.Command.commandlogic.DeleteCommand;
import com.mike.patterns.behavioral.Command.commandlogic.InsertCommand;
import com.mike.patterns.behavioral.Command.commandlogic.SelectCommand;
import com.mike.patterns.behavioral.Command.commandlogic.UpdateCommand;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    public static void main(String[] args) throws SQLException {
        Database database = new Database();

        Developer developer = new Developer(
                new InsertCommand(database),
                new UpdateCommand(database),
                new DeleteCommand(database),
                new SelectCommand(database)
        );
        String selectQuery = "SELECT * FROM new_table";
        ResultSet resultSet = developer.selectRecord(selectQuery);
        int lastId = 0;
        System.out.println("===============");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("header") + " - " + resultSet.getString("text"));
            lastId = resultSet.getInt("id");
        }
        System.out.println("===============");

        lastId += 1;
        String insertQuery = "INSERT INTO new_table VALUES (" + lastId + ", 'Command pattern', 'This message was send from JDBC + Command pattern')";
        boolean insertResult = developer.insertRecord(insertQuery);
        if (insertResult) {
            System.out.println("New column was successfully sent");
        }
        selectAll(selectQuery, developer);

        String updateQuery = "UPDATE new_table SET header = 'UPDATED HEADER', text = 'New updated text :)' WHERE id = " + lastId;
        boolean isUpdated = developer.updateRecord(updateQuery);
        if (isUpdated) {
            System.out.println("ID = " + lastId + " column was successfully updated");
        }
        selectAll(selectQuery, developer);

        String deleteQuery = "DELETE FROM new_table WHERE id = " + lastId;
        boolean isDeleted = developer.deleteRecord(deleteQuery);
        if (isDeleted) {
            System.out.println("ID = " + lastId + " column was successfully deleted");
        }
        selectAll(selectQuery, developer);

    }

    private static void selectAll(String selectQuery, Developer developer) throws SQLException {
        ResultSet resultSet = developer.selectRecord(selectQuery);
        System.out.println("===============");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ": " + resultSet.getString("header") + " - " + resultSet.getString("text"));
        }
        System.out.println("===============");
    }
}
