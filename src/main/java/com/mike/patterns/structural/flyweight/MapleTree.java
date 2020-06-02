package com.mike.patterns.structural.flyweight;

public class MapleTree implements Tree {
    @Override
    public void grow() {
        System.out.println("Maple tree grew " + System.identityHashCode(this));
    }
}
