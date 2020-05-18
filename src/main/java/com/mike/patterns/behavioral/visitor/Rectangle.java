package com.mike.patterns.behavioral.visitor;

public class Rectangle implements Shape {
    private final int id;
    private final float x;
    private final float y;

    public Rectangle(int id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle...");
        String rectangle = """
                                 x 
                 ---------------------------------
                 |                               |
                 |                               |
                 |                               | y
                 |                               |
                 |                               |
                 ---------------------------------
                """;
        System.out.println("x = " + this.x +
                "\ny = " + this.y +
                "\nRectangle:\n" + rectangle);
    }

    @Override
    public void move(float x, float y) {
        System.out.println("Moving rectangle with id = " + this.id + "...");
        System.out.println("New x = " + x + "\nNew y = " + y);
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public int getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
