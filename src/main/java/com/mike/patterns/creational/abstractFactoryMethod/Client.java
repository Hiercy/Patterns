package com.mike.patterns.creational.abstractFactoryMethod;

import com.mike.patterns.creational.abstractFactoryMethod.levels.EasyLevelFactory;
import com.mike.patterns.creational.abstractFactoryMethod.levels.HardLevelFactory;
import com.mike.patterns.creational.abstractFactoryMethod.levels.MiddleLevelFactory;

public class Client {
    public enum LevelType {
        EASY, MIDDLE, HARD
    }

    public static Game makeFactory(LevelType type) {
        GameFactory factory;
        switch (type) {
            case EASY -> {
                factory = new EasyLevelFactory();
                return new Game(factory);
            }
            case MIDDLE -> {
                factory = new MiddleLevelFactory();
                return new Game(factory);
            }
            case HARD -> {
                factory = new HardLevelFactory();
                return new Game(factory);
            }
            default -> {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("======= Easy =======");
        startTheGame(LevelType.EASY);


        System.out.println("\n======= Middle =======");
        startTheGame(LevelType.MIDDLE);

        System.out.println("\n======= Hard =======");
        startTheGame(LevelType.HARD);
    }

    public static void startTheGame(LevelType type) {
        Game game = makeFactory(type);
        assert game != null;
        game.start();
    }
}
