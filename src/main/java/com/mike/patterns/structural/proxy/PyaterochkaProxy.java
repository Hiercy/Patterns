package com.mike.patterns.structural.proxy;

public class PyaterochkaProxy implements Shop {

    private static final int NUM_PEOPLE_ALLOWED = 3;
    private int userCount;
    private final PyaterochkaShop pyaterochkaShop;

    public PyaterochkaProxy(PyaterochkaShop pyaterochkaShop) {
        this.pyaterochkaShop = pyaterochkaShop;
    }

    @Override
    public void enter(User user) {
        if (userCount < NUM_PEOPLE_ALLOWED) {
            pyaterochkaShop.enter(user);
            userCount++;
        } else {
            System.out.println("Sorry " + user.toString() + " you need to wait until people come out. Coronavirus...");
        }
    }
}
