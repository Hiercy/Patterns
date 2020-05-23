package com.mike.patterns.creational.prototype.simplePrototype;

import java.util.Objects;

public class Circle extends Shape {

    public int radius;

    public Circle() {
    }

    public Circle(Circle obj) {
        super(obj);
        if (obj != null) {
            this.radius = obj.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}
