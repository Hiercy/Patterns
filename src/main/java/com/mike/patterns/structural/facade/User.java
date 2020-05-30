package com.mike.patterns.structural.facade;

public class User {
    private final String name;
    // May be department

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
