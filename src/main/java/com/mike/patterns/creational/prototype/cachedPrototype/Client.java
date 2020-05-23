package com.mike.patterns.creational.prototype.cachedPrototype;

import com.mike.patterns.creational.prototype.simplePrototype.Circle;
import com.mike.patterns.creational.prototype.simplePrototype.Shape;

public class Client {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.x = 70;
        circle.y = 90;
        circle.radius = 100;
        circle.color = "Blue";

        ShapeCache cache = new ShapeCache();
        cache.put("Blue Circle", circle);

        Shape shape1 = cache.get("Green Rectangle");
        Shape shape2 = cache.get("Green Rectangle");
        Shape shape3 = cache.get("Red Circle");
        Shape shape4 = cache.get("Red Circle");
        Shape shape5 = cache.get("Blue Circle");
        Shape shape6 = cache.get("Blue Circle");

        System.out.println("=== Green Rectangle ===");
        if (shape1.equals(shape2)) {
            System.out.println("Rectangles are equals");
        }
        if (shape1 == shape2) {
            System.out.println("Rectangle Links are equal");
        }

        System.out.println("=== Red Circle ===");
        if (shape3.equals(shape4)) {
            System.out.println("Red circle values are equals");
        }
        if (shape3 == shape4) {
            System.out.println("Red circle links are equals");
        }
        System.out.println("=== Blue Circle ===");
        if (shape5.equals(shape6)) {
            System.out.println("Blue circle values are equals");
        }
        if (shape5 == shape6) {
            System.out.println("Blue circle links are equals");
        }
    }
}
