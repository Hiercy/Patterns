package com.mike.patterns.behavioral.iterator.service;


import com.mike.patterns.behavioral.iterator.entity.User;
import com.mike.patterns.behavioral.iterator.entity.UserRole;
import com.mike.patterns.behavioral.iterator.repository.UserRepository;
import com.mike.patterns.behavioral.iterator.util.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserRepository {

    private final MyConnection connection;

    public UserService(MyConnection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String queryToSelect = "SELECT * FROM users;";
        ResultSet result = connection.select(queryToSelect);
        List<User> users = new ArrayList<>();
        while (result.next()) {
            users.add(getUserFromResultSet(result));
        }

        return users;
    }

    @Override
    public User findById(Long id) throws SQLException {
        String queryToSelectByUserId = "SELECT * FROM users WHERE id = " + id + ";";
        ResultSet result = connection.select(queryToSelectByUserId);
        User user = null;
        while (result.next()) {
            user = getUserFromResultSet(result);
        }
        return user;
    }

    @Override
    public List<User> findByName(String name) throws SQLException {
        String queryToSelectByName = "SELECT * FROM users WHERE name = '" + name + "';";
        ResultSet result = connection.select(queryToSelectByName);
        List<User> users = new ArrayList<>();
        while (result.next()) {
            users.add(getUserFromResultSet(result));
        }
        return users;
    }

    @Override
    public void deleteById(Long id) {
        String queryToDeleteById = "DELETE FROM users WHERE id = " + id + ";";
        boolean isDeleted = connection.delete(queryToDeleteById);
        if (!isDeleted) {
            System.out.println("Cannot delete user by id = " + id);
        }
    }

    @Override
    public void deleteAll(String queryToDelete) {
        boolean isTruncated = connection.delete(queryToDelete);
        if (!isTruncated) {
            System.out.println("Cannot truncate table");
        }
    }

    @Override
    public void addNewUser(User user) throws SQLException {
        String queryToInsertUser = "INSERT INTO users VALUES( '" +
                user.getId() + "', '" +
                user.getName() + "', '" +
                user.getPassword() + "', '" +
                user.getEmail() + "', '" +
                user.getPhone() + "', '" +
                user.getUserRole().toString() + "');";

        boolean isInserted = connection.insert(queryToInsertUser);
        if (!isInserted) {
            System.out.println("Cannot insert new user with id = " + user.getId() + ". With name = " + user.getName());
        }
        insertUserSkills(user);
    }

    private void insertUserSkills(User user) throws SQLException {
        Long userId = user.getId();
        for (int i = 0; i < user.getSkills().size(); i++) {
            String us = user.getSkills().get(i).getSkill();
            String queryToSelecSkills = "SELECT id FROM skills WHERE skill = '" + us.toUpperCase() + "';";
            ResultSet resultSet = connection.select(queryToSelecSkills);
            int skillId = 0;
            while (resultSet.next()) {
                skillId = resultSet.getInt("id");
            }
            if (skillId == 0) {
                skillId = insertIntoSkills(us);
                System.out.println("Cannot get skill id");
            }
            String queryToInsertSkill = "INSERT INTO user_skills VALUES( '" + userId + "', " + skillId + ");";
            connection.insert(queryToInsertSkill);
        }
    }

    private int insertIntoSkills(String skillName) throws SQLException {
        String getLastId = "SELECT MAX(id) FROM skills";
        ResultSet resultSet = connection.select(getLastId);
        int lastIndex = 0;
        while (resultSet.next()) {
            lastIndex = resultSet.getInt("max");
        }
        String queryToInsertIntoSkills = "INSERT INTO skills VALUES( " + ++lastIndex + ", '" + skillName.toUpperCase() + "');";
        boolean isInserted = connection.insert(queryToInsertIntoSkills);

        if (!isInserted) {
            System.out.println("Cannot insert skill");
        }

        return lastIndex;
    }

    @Override
    public void editUser(User user) {
        String queryToUpdate = "UPDATE users SET name = '" + user.getName() + "', "
                + "password = '" + user.getPassword() + "', "
                + "email = '" + user.getEmail() + "', "
                + "phone = '" + user.getPhone() + "', "
                + "user_role = '" + user.getUserRole().toString() + "' "
                + "WHERE id = " + user.getId() + ";";

        boolean isUpdated = connection.update(queryToUpdate);
        if (!isUpdated) {
            System.out.println("Cannot update user = " + user.getName() + ". With id = " + user.getId());
        }
    }

    private User getUserFromResultSet(ResultSet result) throws SQLException {
        Long id = result.getLong("id");
        String name = result.getString("name");
        String password = result.getString("password");
        String email = result.getString("email");
        String phone = result.getString("phone");
        String userRole = result.getString("user_role");
        UserRole userRoleObj;
        if (userRole.equals("ADMIN")) {
            userRoleObj = UserRole.ADMIN;
        } else {
            userRoleObj = UserRole.USER;
        }

        return new User(id, name, password, email, phone, userRoleObj);
    }
}
