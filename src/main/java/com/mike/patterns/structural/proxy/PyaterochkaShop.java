package com.mike.patterns.structural.proxy;

public class PyaterochkaShop implements Shop {
    @Override
    public void enter(User user) {
        System.out.println(user + " enter pyaterochka.");
    }
}
