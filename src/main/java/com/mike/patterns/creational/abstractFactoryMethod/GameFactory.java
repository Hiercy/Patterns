package com.mike.patterns.creational.abstractFactoryMethod;

import com.mike.patterns.creational.abstractFactoryMethod.enemy.Enemy;
import com.mike.patterns.creational.abstractFactoryMethod.hero.Hero;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Landscape;

import java.util.List;

public interface GameFactory {
    Enemy createEnemy();

    List<Landscape> createLandscape();

    Hero createHero();
}
