package com.mike.patterns.structural.bridge.developers;

public class PhpDeveloper implements Developer {
    @Override
    public void makeProduct() {
        System.out.println("Writing php code");
    }
}
