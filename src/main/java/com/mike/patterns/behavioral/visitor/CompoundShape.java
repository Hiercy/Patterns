package com.mike.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {
    private int id;
    private List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void draw() {
        for (Shape figure : children) {
            figure.draw();
        }
    }

    @Override
    public void move(float x, float y) {
        for (Shape figure : children) {
            figure.move(x, y);
        }
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public void add(Shape shape) {
        children.add(shape);
    }

    public int getId() {
        return id;
    }

    public List<Shape> getChildren() {
        return children;
    }
}
