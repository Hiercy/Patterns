package com.mike.patterns.behavioral.visitor;


public class Client {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 9, 4);
        Triangle triangle = new Triangle(2, 13, 5);
        Square square = new Square(3, 4, 4);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);
        compoundShape.add(square);
        compoundShape.draw();
        compoundShape.move(11, 11);

        CompoundShape compoundShape1 = new CompoundShape(5);
        compoundShape1.add(square);


        XMLWriter xmlWriter = new XMLWriter();
        System.out.println(xmlWriter.export(compoundShape));
        System.out.println(xmlWriter.export(compoundShape1));
    }
}
