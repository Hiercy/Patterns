package com.mike.patterns.behavioral.command.commandlogic;

import java.sql.SQLException;

public interface Command {
    Object execute(String query) throws SQLException;
}
