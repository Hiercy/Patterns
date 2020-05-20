package com.mike.patterns.creational.factoryMethod.enemies;

public class ElfEnemy implements Enemy {

    @Override
    public void attack() {
        System.out.println("Elf starts attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("*cultural roar*");
    }

    @Override
    public String toString() {
        return "Elf";
    }
}
