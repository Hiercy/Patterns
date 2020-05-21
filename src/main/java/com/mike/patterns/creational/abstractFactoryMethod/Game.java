package com.mike.patterns.creational.abstractFactoryMethod;

import com.mike.patterns.creational.abstractFactoryMethod.enemy.Enemy;
import com.mike.patterns.creational.abstractFactoryMethod.hero.Hero;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Landscape;

import java.util.List;

public class Game {
    private final Enemy enemy;
    private final List<Landscape> landscape;
    private final Hero hero;

    public Game(GameFactory factory) {
        this.enemy = factory.createEnemy();
        this.landscape = factory.createLandscape();
        this.hero = factory.createHero();
    }

    public void start() {
        enemy.battleRoar();
        enemy.attack();

        hero.run();
        hero.useSkills();

        landscape.forEach(Landscape::action);
    }
}
