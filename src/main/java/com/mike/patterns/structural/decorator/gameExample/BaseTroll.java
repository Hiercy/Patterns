package com.mike.patterns.structural.decorator.gameExample;

public class BaseTroll implements Troll {
    @Override
    public void attack() {
        System.out.print("The troll attacks you");
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public void escape() {
        System.out.println("Troll escapes");
    }
}
