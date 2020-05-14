package com.mike.patterns.behavioral.strategy;

public class GunStrategy implements BossSlayerStrategy{
    @Override
    public String fight() {
        return "Shooting boss with the gun";
    }
}
