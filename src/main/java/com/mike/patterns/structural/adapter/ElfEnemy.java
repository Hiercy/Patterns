package com.mike.patterns.structural.adapter;

public class ElfEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Elf use a bow to attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("*culture roar*");
    }
}
