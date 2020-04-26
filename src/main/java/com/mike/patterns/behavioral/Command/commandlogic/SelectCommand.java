package com.mike.patterns.behavioral.Command.commandlogic;

import com.mike.patterns.behavioral.Command.Database;

public class SelectCommand implements Command {
    private final Database database;

    public SelectCommand(Database database) {
        this.database = database;
    }

    @Override
    public Object execute(String query) {
        return database.select(query);
    }
}
