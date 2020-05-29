package com.mike.patterns.structural.decorator.gameExample;

public class AxedTroll extends BaseTroll {

    private Troll decorator;

    public AxedTroll(Troll decorator) {
        this.decorator = decorator;
    }

    @Override
    public void attack() {
        decorator.attack();
        System.out.print(" with axe!");
    }

    @Override
    public int getDamage() {
        return decorator.getDamage() + 20;
    }
}
