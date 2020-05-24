package com.mike.patterns.structural.adapter;

public class Client {
    public static void main(String[] args) {
        OrcEnemy orc = new OrcEnemy();
        ElfEnemy elf = new ElfEnemy();
        UndeadEnemy undead = new UndeadEnemy();

        Enemy robot = new EnemyAdapter(new RobotEnemy());

        System.out.println("=== Orc ===");
        orc.attack();
        orc.battleRoar();

        System.out.println("\n=== Elf ===");
        elf.attack();
        elf.battleRoar();

        System.out.println("\n=== Undead ===");
        undead.attack();
        undead.battleRoar();

        System.out.println("\n=== Robot ===");
        robot.attack();
        robot.battleRoar();
    }
}
