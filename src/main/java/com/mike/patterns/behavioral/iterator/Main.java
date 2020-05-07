package com.mike.patterns.behavioral.iterator;


import com.mike.patterns.behavioral.iterator.controller.UserController;
import com.mike.patterns.behavioral.iterator.entity.Skills;
import com.mike.patterns.behavioral.iterator.entity.User;
import com.mike.patterns.behavioral.iterator.entity.UserRole;
import com.mike.patterns.behavioral.iterator.entity.iterator.Iterator;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserController userController = new UserController();
        AtomicLong id = new AtomicLong(15);
        List<User> users = List.of(
                new User(id.incrementAndGet(), "Alan", "1234", "mike.mike@gmail.com", "+123456789", UserRole.ADMIN, List.of(new Skills("Java"), new Skills("Spring"))),
                new User(id.incrementAndGet(), "John", "5678", "john.john@gmail.com", "+123456789", UserRole.USER, List.of(new Skills("Python"), new Skills("Vue.js"))),
                new User(id.incrementAndGet(), "Bob", "9101", "bob.bob@gmail.com", "+123456789", UserRole.USER, List.of(new Skills("Sql"), new Skills("Hibernate")))
        );

        // Iterator pattern
        Iterator skillIterator = users.get(0).getIterator();
        while (skillIterator.hasNext()) {
            Skills skills = (Skills) skillIterator.next();
            System.out.println(skills.getSkill());
        }

        userController.deleteAllUsers();
        userController.deleteAllUserSkills();
        users.stream()
                .peek(user -> System.out.println(user + " Was added"))
                .forEach(user -> {
                    try {
                        userController.addNewUser(user);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        userController.selectAllUsers().forEach(System.out::println);

        userController.selectAllUsers().forEach(System.out::println);

        users.stream()
                .filter(user -> user.getUserRole() != UserRole.ADMIN)
                .map(User::getId)
                .peek(user -> System.out.println(user + " Was deleted"))
                .forEach(userController::deleteUser);
        userController.selectAllUsers().forEach(System.out::println);

        users.stream()
                .filter(user -> user.getUserRole() != UserRole.ADMIN)
                .peek(user -> System.out.println(user + " Was added"))
                .forEach(user -> {
                    try {
                        userController.addNewUser(user);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        userController.selectAllUsers().forEach(System.out::println);

        User updatedUser = users.get(0);
        updatedUser.setName("Mike");
        updatedUser.setPassword("741852");
        userController.updateUser(updatedUser);
        userController.selectAllUsers().forEach(System.out::println);

        System.out.println("===================");
        users.forEach(user -> {
            try {
                System.out.println(userController.getUserById(user.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        System.out.println("===================");
        users.forEach(user -> {
            try {
                System.out.println(userController.getUserByName(user.getName()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
