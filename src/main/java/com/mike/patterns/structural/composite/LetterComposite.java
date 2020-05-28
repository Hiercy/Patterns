package com.mike.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class LetterComposite {

    private final List<LetterComposite> children = new ArrayList<>();

    public void add(LetterComposite letter) {
        children.add(letter);
    }

    public int count() {
        return children.size();
    }

    public abstract void printBefore();
    public abstract void printAfter();

    public void print() {
        printBefore();
        children.forEach(LetterComposite::print);
        printAfter();
    }
}
