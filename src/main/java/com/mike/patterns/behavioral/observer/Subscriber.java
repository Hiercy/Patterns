package com.mike.patterns.behavioral.observer;

import java.util.List;

public class Subscriber implements Listener {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Hello " + name + "!\nWe have some new vacancies for you:\n" + vacancies +
                "\n===================================");
    }
}
