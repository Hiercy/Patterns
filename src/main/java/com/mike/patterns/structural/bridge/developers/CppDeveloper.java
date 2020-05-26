package com.mike.patterns.structural.bridge.developers;

public class CppDeveloper implements Developer {
    @Override
    public void makeProduct() {
        System.out.println("Writing cpp code");
    }
}
