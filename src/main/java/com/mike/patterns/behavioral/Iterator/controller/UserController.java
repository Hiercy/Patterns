package com.mike.patterns.behavioral.Iterator.controller;


import com.mike.patterns.behavioral.Iterator.entity.User;
import com.mike.patterns.behavioral.Iterator.service.UserService;
import com.mike.patterns.behavioral.Iterator.util.MyConnection;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private MyConnection connection;
    private UserService userService;

    public UserController() {
        connection = new MyConnection();
        userService = new UserService(connection);
    }

    public void addNewUser(User user) throws SQLException {
        userService.addNewUser(user);
    }

    public void updateUser(User user) {
        userService.editUser(user);
    }

    public void deleteUser(Long id) {
        userService.deleteById(id);
    }

    public void deleteAllUsers() {
        String queryToDeleteAll = "TRUNCATE TABLE users CASCADE";
        userService.deleteAll(queryToDeleteAll);
    }

    public List<User> selectAllUsers() throws SQLException {
        return userService.findAll();
    }

    public User getUserById(Long id) throws SQLException {
        return userService.findById(id);
    }

    public List<User> getUserByName(String name) throws SQLException {
        return userService.findByName(name);
    }

    public void deleteAllSkills() {
        String queryToDeleteAll = "TRUNCATE TABLE skills CASCADE";
        userService.deleteAll(queryToDeleteAll);
    }

    public void deleteAllUserSkills() {
        String queryToDeleteAll = "TRUNCATE TABLE user_skills CASCADE";
        userService.deleteAll(queryToDeleteAll);
    }
}
