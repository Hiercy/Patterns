package com.mike.patterns.structural.facade;

public enum TaskType {
    TASK("Task"), BUG("Bug"), STORY("Story"), EPIC("Epic");

    String title;

    TaskType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
