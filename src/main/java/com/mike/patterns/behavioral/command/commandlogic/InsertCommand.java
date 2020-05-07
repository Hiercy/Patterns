package com.mike.patterns.behavioral.command.commandlogic;

import com.mike.patterns.behavioral.command.Database;

import java.sql.SQLException;

public class InsertCommand implements Command {
    private final Database database;

    public InsertCommand(Database database) {
        this.database = database;
    }

    @Override
    public Object execute(String query) throws SQLException {
        return database.insert(query);
    }

}
