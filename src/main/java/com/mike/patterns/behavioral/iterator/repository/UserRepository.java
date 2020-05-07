package com.mike.patterns.behavioral.iterator.repository;


import com.mike.patterns.behavioral.iterator.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> findAll() throws SQLException;

    User findById(Long id) throws SQLException;

    List<User> findByName(String name) throws SQLException;

    void deleteById(Long id) throws SQLException;

    void deleteAll(String queryToDelete);

    void addNewUser(User user) throws SQLException;

    void editUser(User user) throws SQLException;
}
