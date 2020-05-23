package com.mike.patterns.creational.prototype.simplePrototype;

public class Client {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "Red";

        Circle circle1 = (Circle) circle.clone();
        System.out.println(circle.equals(circle1));
        System.out.println("First circle:\nx = " + circle.x + "\ny = " + circle.y + "\nradius = " + circle.radius + "\ncolor = " + circle.color);
        System.out.println("Cloned circle:\nx = " + circle1.x + "\ny = " + circle1.y + "\nradius = " + circle1.radius + "\ncolor = " + circle1.color);

        Rectangle rectangle = new Rectangle();
        rectangle.height = 10;
        rectangle.width = 20;
        rectangle.color = "Green";

        Rectangle rectangle1 = (Rectangle) rectangle.clone();
        System.out.println(rectangle.equals(rectangle1));
        System.out.println("First rectangle:\nwidth = " + rectangle.width + "\nheight = " + rectangle.height + "\ncolor = " + rectangle.color);
        System.out.println("Cloned rectangle:\nwidth = " + rectangle1.width + "\nheight = " + rectangle1.height + "\ncolor = " + rectangle1.color);
    }
}
