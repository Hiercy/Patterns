package com.mike.patterns.creational.abstractFactoryMethod.enemy;

public class ElfEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Elf start attack you");
    }

    @Override
    public void battleRoar() {
        System.out.println("*Culture roar*");
    }
}
