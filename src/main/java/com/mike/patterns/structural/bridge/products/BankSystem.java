package com.mike.patterns.structural.bridge.products;

import com.mike.patterns.structural.bridge.developers.Developer;

public class BankSystem extends Product {

    public BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void develop() {
        System.out.println("Create bank system");
        developer.makeProduct();
    }
}
