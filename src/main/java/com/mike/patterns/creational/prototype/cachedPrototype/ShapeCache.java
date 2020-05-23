package com.mike.patterns.creational.prototype.cachedPrototype;

import com.mike.patterns.creational.prototype.simplePrototype.Circle;
import com.mike.patterns.creational.prototype.simplePrototype.Rectangle;
import com.mike.patterns.creational.prototype.simplePrototype.Shape;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {
    private final Map<String, Shape> cache = new HashMap<>();

    public ShapeCache() {
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "Red";

        Rectangle rectangle = new Rectangle();
        rectangle.height = 10;
        rectangle.width = 20;
        rectangle.color = "Green";

        cache.put("Red Circle", circle);
        cache.put("Green Rectangle", rectangle);
    }

    public void put(String key, Shape val) {
        cache.put(key, val);
    }

    public Shape get(String key) {
        return cache.get(key);
    }
}
