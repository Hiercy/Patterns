package com.mike.patterns.structural.facade;

public enum PriorityType {
    LOWEST("Lowest"), LOW("Low"), MEDIUM("Medium"), HIGH("High"), HIGHEST("Highest");

    String title;

    PriorityType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
