package com.mike.patterns.structural.composite;

public class Letter extends LetterComposite {
    private char character;

    public Letter(char character) {
        this.character = character;
    }

    @Override
    public void printBefore() {
        System.out.print(character);
    }

    @Override
    public void printAfter() {
        System.out.print("");
    }
}
