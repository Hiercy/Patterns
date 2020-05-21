package com.mike.patterns.creational.abstractFactoryMethod.enemy;

public class OrcEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Orc start attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("AAARARAAARRAR");
    }
}
