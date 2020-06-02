package com.mike.patterns.structural.flyweight;

public class OakTree implements Tree {
    @Override
    public void grow() {
        System.out.println("Oak tree grew " + System.identityHashCode(this));
    }
}
