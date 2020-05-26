package com.mike.patterns.structural.bridge.developers;

public class JavaDeveloper implements Developer {
    @Override
    public void makeProduct() {
        System.out.println("Writing java code");
    }
}
