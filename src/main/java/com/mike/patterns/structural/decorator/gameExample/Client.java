package com.mike.patterns.structural.decorator.gameExample;

public class Client {
    public static void main(String[] args) {
        Troll baseTroll = new BaseTroll();
        baseTroll.attack();
        System.out.println(" with bare hands! Damage = " + baseTroll.getDamage());

        System.out.println("=====");

        Troll clubbedTroll = new ClubbedTroll(new BaseTroll());
        clubbedTroll.attack();
        System.out.println(" With damage = " + clubbedTroll.getDamage());
        clubbedTroll.escape();

        System.out.println("=====");

        Troll axedTroll = new AxedTroll(new BaseTroll());
        axedTroll.attack();
        System.out.println(" Damage = " + axedTroll.getDamage());
        axedTroll.escape();

        System.out.println("=====");

        Troll severalTrolls = new AxedTroll(new ClubbedTroll(new BaseTroll()));
        severalTrolls.attack();
        System.out.println();
        severalTrolls.escape();
    }
}
