package com.mike.patterns.creational.abstractFactoryMethod.levels;

import com.mike.patterns.creational.abstractFactoryMethod.GameFactory;
import com.mike.patterns.creational.abstractFactoryMethod.enemy.ElfEnemy;
import com.mike.patterns.creational.abstractFactoryMethod.enemy.Enemy;
import com.mike.patterns.creational.abstractFactoryMethod.hero.Hero;
import com.mike.patterns.creational.abstractFactoryMethod.hero.SpiderMan;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Bench;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Landscape;
import com.mike.patterns.creational.abstractFactoryMethod.landscape.Tree;

import java.util.List;

public class MiddleLevelFactory implements GameFactory {

    @Override
    public Enemy createEnemy() {
        return new ElfEnemy();
    }

    @Override
    public List<Landscape> createLandscape() {
        return List.of(
                new Tree(),
                new Tree(),
                new Bench(),
                new Bench(),
                new Bench()
        );
    }

    @Override
    public Hero createHero() {
        return new SpiderMan();
    }
}
