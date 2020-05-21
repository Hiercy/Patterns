package com.mike.patterns.creational.abstractFactoryMethod.hero;

public class SpiderMan implements Hero {
    @Override
    public void run() {
        System.out.println("Spider man flies on the web");
    }

    @Override
    public void useSkills() {
        System.out.println("Shoots a web");
    }
}
