package com.mike.patterns.behavioral.Command;

import com.mike.patterns.behavioral.Command.commandlogic.Command;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Developer {
    private final Command insert;
    private final Command update;
    private final Command delete;
    private final Command select;

    public Developer(Command insert, Command update, Command delete, Command select) {
        this.insert = insert;
        this.update = update;
        this.delete = delete;
        this.select = select;
    }

    public boolean insertRecord(String query) throws SQLException {
        return (boolean) insert.execute(query);
    }

    public boolean updateRecord(String query) throws SQLException {
        return (boolean) update.execute(query);
    }

    public boolean deleteRecord(String query) throws SQLException {
        return (boolean) delete.execute(query);
    }

    public ResultSet selectRecord(String query) throws SQLException {
        return (ResultSet) select.execute(query);
    }
}
