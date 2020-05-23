package com.mike.patterns.creational.singleton.staticMethod;

public class Singleton {
    public String title;
    private static Singleton instance;

    private Singleton(String title) {
        this.title = title;
    }

    public static Singleton getInstance(String title) {
        if (instance == null) {
            instance = new Singleton(title);
        }
        return instance;
    }
}
