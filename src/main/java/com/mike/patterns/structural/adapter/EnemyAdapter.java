package com.mike.patterns.structural.adapter;

public class EnemyAdapter implements Enemy {

    RobotEnemy robotEnemy;

    public EnemyAdapter(RobotEnemy robotEnemy) {
        this.robotEnemy = robotEnemy;
    }

    @Override
    public void attack() {
        robotEnemy.useLaserGun();
    }

    @Override
    public void battleRoar() {
        System.out.println("Robot haven't battle roar. So robot go to refill and start walking forward");
        robotEnemy.refill();
        robotEnemy.walkForward();
    }
}
