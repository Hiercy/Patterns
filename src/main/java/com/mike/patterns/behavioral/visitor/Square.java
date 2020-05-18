package com.mike.patterns.behavioral.visitor;

public class Square implements Shape {
    private final int id;
    private final float x;
    private final float y;

    public Square(int id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing square...");
        String square = """
                        x
                 ----------------
                 |              |
                 |              |
                 |              | y
                 |              |
                 |              |
                 ----------------
                """;
        System.out.println("x = " + this.x +
                "\ny = " + this.y +
                "\nSquare:\n" + square);
    }

    @Override
    public void move(float x, float y) {
        System.out.println("Moving square with id = " + this.id + "...");
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
