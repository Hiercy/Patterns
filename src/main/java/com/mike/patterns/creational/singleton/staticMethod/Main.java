package com.mike.patterns.creational.singleton.staticMethod;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("First init");
        Singleton anotherSingleton = Singleton.getInstance("Second init");

        System.out.println(singleton.title);
        System.out.println(anotherSingleton.title);
    }
}
