package com.mike.patterns.creational.factoryMethod.levels;

import com.mike.patterns.creational.factoryMethod.enemies.Enemy;

import java.util.List;

public interface Level {
    List<Enemy> createLevel();
}
