package com.mike.patterns.creational.factoryMethod.enemies;

public class OrcsEnemy implements Enemy {

    @Override
    public void attack() {
        System.out.println("Orc starts attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("AARARRAAAAAAAAAAA");
    }

    @Override
    public String toString() {
        return "Orc";
    }
}
