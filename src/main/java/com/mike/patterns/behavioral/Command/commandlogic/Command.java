package com.mike.patterns.behavioral.Command.commandlogic;

import java.sql.SQLException;

public interface Command {
    Object execute(String query) throws SQLException;
}
