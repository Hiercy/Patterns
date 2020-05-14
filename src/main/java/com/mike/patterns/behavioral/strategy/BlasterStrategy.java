package com.mike.patterns.behavioral.strategy;

public class BlasterStrategy implements BossSlayerStrategy {
    @Override
    public String fight() {
        return "Charging your blaster from the sun power";
    }
}
