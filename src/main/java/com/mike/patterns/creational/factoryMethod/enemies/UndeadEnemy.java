package com.mike.patterns.creational.factoryMethod.enemies;

public class UndeadEnemy implements Enemy {

    @Override
    public void attack() {
        System.out.println("Undead starts attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("...");
    }

    @Override
    public String toString() {
        return "Undead";
    }
}
