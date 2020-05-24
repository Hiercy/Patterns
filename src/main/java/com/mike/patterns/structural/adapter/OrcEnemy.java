package com.mike.patterns.structural.adapter;

public class OrcEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Orc use an ax to attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("AAARARARARRAAAR");
    }
}
