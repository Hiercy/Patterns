package com.mike.patterns.structural.bridge.products;

import com.mike.patterns.structural.bridge.developers.Developer;

public abstract class Product {

    protected Developer developer;

    protected Product(Developer developer) {
        this.developer = developer;
    }

    public abstract void develop();
}
