package com.mike.patterns.structural.decorator.gameExample;

public class ClubbedTroll extends BaseTroll {

    private final Troll decorator;

    public ClubbedTroll(Troll decorator) {
        this.decorator = decorator;
    }

    @Override
    public int getDamage() {
        return decorator.getDamage() + 10;
    }

    @Override
    public void attack() {
        decorator.attack();
        System.out.print(" with club!");
    }
}
