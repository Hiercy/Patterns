package com.mike.patterns.creational.prototype.simplePrototype;

import java.util.Objects;

public abstract class Shape {

    public int x;
    public int y;
    public String color;

    public Shape() {
    }

    public Shape(Shape obj) {
        if (obj != null) {
            this.x = obj.x;
            this.y = obj.y;
            this.color = obj.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return x == shape.x &&
                y == shape.y &&
                color.equals(shape.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }
}
