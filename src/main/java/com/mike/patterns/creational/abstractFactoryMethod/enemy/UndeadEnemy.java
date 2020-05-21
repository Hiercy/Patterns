package com.mike.patterns.creational.abstractFactoryMethod.enemy;

public class UndeadEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Undead start attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("...");
    }
}
