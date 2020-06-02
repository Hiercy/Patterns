package com.mike.patterns.structural.flyweight;

public class Client {
    public static void main(String[] args) {
        TreeFactory factory = new TreeFactory();

        for (int i = 0; i < 50; i++) {
            factory.createTree(TreeType.OAK).grow();
        }
        for (int i = 0; i < 50; i++) {
            factory.createTree(TreeType.MAPLE).grow();
        }
    }
}
