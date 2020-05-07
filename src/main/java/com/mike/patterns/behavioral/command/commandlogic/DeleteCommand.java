package com.mike.patterns.behavioral.command.commandlogic;

import com.mike.patterns.behavioral.command.Database;

import java.sql.SQLException;

public class DeleteCommand implements Command {
    private final Database database;

    public DeleteCommand(Database database) {
        this.database = database;
    }

    @Override
    public Object execute(String query) throws SQLException {
        return database.delete(query);
    }
}
