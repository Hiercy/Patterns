package com.mike.patterns.behavioral.mediator;

public class AdminUser implements User {
    private Chat chat;
    private String name;

    public AdminUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + "-admin received message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
