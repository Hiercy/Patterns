package com.mike.patterns.structural.proxy;

public class User {

    private final String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }
}
