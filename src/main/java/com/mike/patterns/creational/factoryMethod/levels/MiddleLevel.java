package com.mike.patterns.creational.factoryMethod.levels;

import com.mike.patterns.creational.factoryMethod.enemies.ElfEnemy;
import com.mike.patterns.creational.factoryMethod.enemies.Enemy;
import com.mike.patterns.creational.factoryMethod.enemies.OrcsEnemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MiddleLevel implements Level {

    private List<Enemy> enemyList = new ArrayList<>();

    public MiddleLevel() {
        enemyList.add(new OrcsEnemy());
        enemyList.add(new ElfEnemy());
    }

    @Override
    public List<Enemy> createLevel() {
        System.out.println("Creating middle level with " + enemyList.stream().map(Objects::toString) + ", trees and benches");
        return enemyList;
    }
}
