package com.mike.patterns.creational.singleton.enumSingleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        Singleton anotherSingleton = Singleton.INSTANCE;

        Singleton.doSomething();

        System.out.println(singleton.hashCode());
        System.out.println(anotherSingleton.hashCode());

        System.out.println(singleton == anotherSingleton);
    }
}
