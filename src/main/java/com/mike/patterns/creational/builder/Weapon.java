package com.mike.patterns.creational.builder;

public enum Weapon {

    KNIFE("Knife"), SWORD("Sword"), AXE("Axe"), CANE("Cane");

    private final String title;

    Weapon(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

