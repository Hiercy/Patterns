package com.mike.patterns.behavioral.visitor;

public class XMLWriter implements Visitor {

    public String export(Shape... args) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : args) {
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
            sb.append(shape.accept(this)).append("\n");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        return sb.toString();
    }

    @Override
    public String visit(Rectangle rectangle) {
        return "<rectangle>\n" +
                "   <id>" + rectangle.getId() + "</id>" + "\n" +
                "   <x>" + rectangle.getX() + "</x>" + "\n" +
                "   <y>" + rectangle.getY() + "</y>" + "\n" +
                "</rectangle>";
    }

    @Override
    public String visit(Square square) {
        return "<square>\n" +
                "   <id>" + square.getId() + "</id>" + "\n" +
                "   <x>" + square.getX() + "</x>" + "\n" +
                "   <y>" + square.getY() + "</y>" + "\n" +
                "</square>";
    }

    @Override
    public String visit(Triangle triangle) {
        return "<triangle>\n" +
                "   <id>" + triangle.getId() + "</id>" + "\n" +
                "   <x>" + triangle.getX() + "</x>" + "\n" +
                "   <y>" + triangle.getY() + "</y>" + "\n" +
                "</triangle>";
    }

    @Override
    public String visit(CompoundShape compoundShape) {
        return "<compoundshape>\n" +
                "   <id>" + compoundShape.getId() + "</id>" + "\n" +
                visitCompoundGraphic(compoundShape) +
                "</compoundshape>";
    }


    private String visitCompoundGraphic(CompoundShape cs) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : cs.getChildren()) {
            String obj = shape.accept(this);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }
}
