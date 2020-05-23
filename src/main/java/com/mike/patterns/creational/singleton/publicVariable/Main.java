package com.mike.patterns.creational.singleton.publicVariable;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        Singleton anotherSingleton = Singleton.INSTANCE;

        System.out.println(singleton == anotherSingleton);
    }
}
