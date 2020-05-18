package com.mike.patterns.behavioral.visitor;

public interface Shape {
    void draw();

    void move(float x, float y);

    String accept(Visitor visitor);
}
