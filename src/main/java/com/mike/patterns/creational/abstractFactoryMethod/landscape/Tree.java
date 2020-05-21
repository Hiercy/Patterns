package com.mike.patterns.creational.abstractFactoryMethod.landscape;

public class Tree implements Landscape {
    @Override
    public void action() {
        System.out.println("Interact with tree");
    }
}
