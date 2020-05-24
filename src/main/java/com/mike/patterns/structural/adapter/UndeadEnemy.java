package com.mike.patterns.structural.adapter;

public class UndeadEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Undead use an ax to attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("...");
    }
}
