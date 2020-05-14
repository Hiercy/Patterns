package com.mike.patterns.behavioral.strategy;

public class Client {
    public static void main(String[] args) {
        BossSlayer bossSlayer = new BossSlayer(new GunStrategy());
        System.out.println(bossSlayer.fightWithTheBoss());

        bossSlayer.setBossSlayerStrategy(new BombStrategy());
        System.out.println(bossSlayer.fightWithTheBoss());

        bossSlayer.setBossSlayerStrategy(new BlasterStrategy());
        System.out.println(bossSlayer.fightWithTheBoss());

        bossSlayer.setBossSlayerStrategy(new BombStrategy());
        System.out.println(bossSlayer.fightWithTheBoss());
    }
}
