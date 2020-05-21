package com.mike.patterns.creational.builder;

public enum Armor {

    RAGS("Rags"), LEATHER("Leather"), CHAIN_MAIL("Chain mail"), PLATE("Plate");

    private final String title;

    Armor(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
