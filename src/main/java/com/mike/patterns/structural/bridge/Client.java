package com.mike.patterns.structural.bridge;

import com.mike.patterns.structural.bridge.developers.CppDeveloper;
import com.mike.patterns.structural.bridge.developers.JavaDeveloper;
import com.mike.patterns.structural.bridge.developers.PhpDeveloper;
import com.mike.patterns.structural.bridge.products.BankSystem;
import com.mike.patterns.structural.bridge.products.Product;

public class Client {
    public static void main(String[] args) {
        Product product = new BankSystem(new JavaDeveloper());
        product.develop();

        product = new BankSystem(new CppDeveloper());
        product.develop();

        product = new BankSystem(new PhpDeveloper());
        product.develop();
    }
}
