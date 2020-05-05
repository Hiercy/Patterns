package com.mike.patterns.behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat {
    private User admin;
    private final List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }

    public void addUserToChat(User user) {
        users.add(user);
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
