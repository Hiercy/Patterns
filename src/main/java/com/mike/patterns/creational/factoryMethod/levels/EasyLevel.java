package com.mike.patterns.creational.factoryMethod.levels;

import com.mike.patterns.creational.factoryMethod.enemies.Enemy;
import com.mike.patterns.creational.factoryMethod.enemies.OrcsEnemy;

import java.util.ArrayList;
import java.util.List;

public class EasyLevel implements Level {

    private List<Enemy> enemyList = new ArrayList<>();

    public EasyLevel() {
        enemyList.add(new OrcsEnemy());
    }

    @Override
    public List<Enemy> createLevel() {
        System.out.println("Creating easy level with " + enemyList + ", trees and benches");
        return enemyList;
    }
}
