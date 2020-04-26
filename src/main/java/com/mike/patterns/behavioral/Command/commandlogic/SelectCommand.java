package com.mike.patterns.behavioral.Command.commandlogic;

import com.mike.patterns.behavioral.Command.Database;

import java.sql.SQLException;

public class SelectCommand implements Command {
    private final Database database;

    public SelectCommand(Database database) {
        this.database = database;
    }

    @Override
    public Object execute(String query) throws SQLException {
        return database.select(query);
    }
}
