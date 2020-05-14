package com.mike.patterns.behavioral.strategy;

public class BombStrategy implements BossSlayerStrategy {
    @Override
    public String fight() {
        return "Dropping bombs on the boss";
    }
}
