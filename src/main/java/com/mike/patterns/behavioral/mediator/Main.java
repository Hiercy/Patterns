package com.mike.patterns.behavioral.mediator;

public class Main {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User adminUser = new AdminUser(chat, "Mike");
        User user1 = new SimpleUser(chat, "John");
        User user2 = new SimpleUser(chat, "Bob");
        User user3 = new SimpleUser(chat, "Den");
        User user4 = new SimpleUser(chat, "Georg");

        chat.setAdmin(adminUser);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);
        chat.addUserToChat(user3);
        chat.addUserToChat(user4);

        adminUser.sendMessage("I'M ADMIN!!!!!!!!");
        user1.sendMessage("No John is Admin!");
    }
}
