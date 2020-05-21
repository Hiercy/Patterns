package com.mike.patterns.creational.abstractFactoryMethod.hero;

public class SimpleMan implements Hero {
    @Override
    public void run() {
        System.out.println("Simple man runs on the ground");
    }

    @Override
    public void useSkills() {
        System.out.println("No superpowers");
    }
}
