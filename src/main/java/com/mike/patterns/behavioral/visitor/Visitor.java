package com.mike.patterns.behavioral.visitor;

public interface Visitor {
    String visit(Rectangle rectangle);

    String visit(Square square);

    String visit(Triangle triangle);

    String visit(CompoundShape compoundShape);
}
