package com.mike.patterns.creational.abstractFactoryMethod.levels;

import com.mike.patterns.creational.abstractFactoryMethod.GameFactory;
import com.mike.patterns.creational.abstractFactoryMethod.enemy.Enemy;
import com.mike.patterns.creational.abstractFactoryMethod.enemy.UndeadEnemy;
import com.mike.patterns.creational.abstractFactoryMethod.hero.Hero;
import com.mike.patterns.creational.abstractFactoryMethod.hero.SimpleMan;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Bench;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Landscape;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Tree;

import java.util.List;

public class HardLevelFactory implements GameFactory {

    @Override
    public Enemy createEnemy() {
        return new UndeadEnemy();
    }

    @Override
    public List<Landscape> createLandscape() {
        return List.of(
                new Bench(),
                new Bench(),
                new Tree(),
                new Tree(),
                new Tree()
        );
    }

    @Override
    public Hero createHero() {
        return new SimpleMan();
    }
}
