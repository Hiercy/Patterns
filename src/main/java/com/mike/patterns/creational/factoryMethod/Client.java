package com.mike.patterns.creational.factoryMethod;

import com.mike.patterns.creational.factoryMethod.enemies.Enemy;
import com.mike.patterns.creational.factoryMethod.levels.EasyLevel;
import com.mike.patterns.creational.factoryMethod.levels.HardLevel;
import com.mike.patterns.creational.factoryMethod.levels.Level;
import com.mike.patterns.creational.factoryMethod.levels.MiddleLevel;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("======= Easy =======");
        create(new EasyLevel());
        System.out.println("\n======= Middle =======");
        create(new MiddleLevel());
        System.out.println("\n======= Hard =======");
        create(new HardLevel());
    }

    public static void create(Level level) {
        List<Enemy> enemies = level.createLevel();
        System.out.println("Level with " + enemies + " created!");
        enemies.forEach(e -> {
            System.out.println("Enemy " + e.toString());
            e.battleRoar();
            e.attack();
        });
    }
}
