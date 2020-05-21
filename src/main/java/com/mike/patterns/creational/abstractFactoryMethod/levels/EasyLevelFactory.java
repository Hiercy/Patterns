package com.mike.patterns.creational.abstractFactoryMethod.levels;

import com.mike.patterns.creational.abstractFactoryMethod.GameFactory;
import com.mike.patterns.creational.abstractFactoryMethod.enemy.Enemy;
import com.mike.patterns.creational.abstractFactoryMethod.enemy.OrcEnemy;
import com.mike.patterns.creational.abstractFactoryMethod.hero.Hero;
import com.mike.patterns.creational.abstractFactoryMethod.hero.SuperMan;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Bench;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Landscape;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Tree;

import java.util.List;

public class EasyLevelFactory implements GameFactory {

    @Override
    public Enemy createEnemy() {
        return new OrcEnemy();
    }

    @Override
    public List<Landscape> createLandscape() {
        return List.of(
                new Tree(),
                new Tree(),
                new Tree(),
                new Bench(),
                new Bench(),
                new Bench()
        );
    }

    @Override
    public Hero createHero() {
        return new SuperMan();
    }
}
