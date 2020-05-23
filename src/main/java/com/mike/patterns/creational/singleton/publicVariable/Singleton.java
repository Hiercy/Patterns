package com.mike.patterns.creational.singleton.publicVariable;

public class Singleton {
    public static int count = 0;
    public static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        System.out.println(++count);
    }
}
