package com.mike.patterns.creational.factoryMethod.levels;

import com.mike.patterns.creational.factoryMethod.enemies.ElfEnemy;
import com.mike.patterns.creational.factoryMethod.enemies.Enemy;
import com.mike.patterns.creational.factoryMethod.enemies.OrcsEnemy;
import com.mike.patterns.creational.factoryMethod.enemies.UndeadEnemy;

import java.util.ArrayList;
import java.util.List;

public class HardLevel implements Level {

    private List<Enemy> enemyList = new ArrayList<>();

    public HardLevel() {
        enemyList.add(new OrcsEnemy());
        enemyList.add(new ElfEnemy());
        enemyList.add(new UndeadEnemy());
    }

    @Override
    public List<Enemy> createLevel() {
        System.out.println("Creating hard level with " + enemyList + ", trees and benches");
        return enemyList;
    }
}
