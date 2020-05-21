package com.mike.patterns.creational.abstractFactoryMethod.hero;

public class SuperMan implements Hero {

    @Override
    public void run() {
        System.out.println("Super man flies with super power");
    }

    @Override
    public void useSkills() {
        System.out.println("Eye laser");
    }
}
