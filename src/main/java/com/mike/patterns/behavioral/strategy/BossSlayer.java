package com.mike.patterns.behavioral.strategy;

public class BossSlayer {
    private BossSlayerStrategy bossSlayerStrategy;

    public BossSlayer(BossSlayerStrategy bossSlayerStrategy) {
        this.bossSlayerStrategy = bossSlayerStrategy;
    }

    public void setBossSlayerStrategy(BossSlayerStrategy bossSlayerStrategy) {
        this.bossSlayerStrategy = bossSlayerStrategy;
    }

    public String fightWithTheBoss() {
        return bossSlayerStrategy.fight();
    }
}
