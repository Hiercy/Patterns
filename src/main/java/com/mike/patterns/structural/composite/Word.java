package com.mike.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Word extends LetterComposite {

    public Word(List<Letter> letters) {
        letters.forEach(this::add);
    }

    public Word(char... characters) {
        for (char character : characters) {
            this.add(new Letter(character));
        }
    }

    @Override
    public void printBefore() {
        System.out.print(" ");
    }

    @Override
    public void printAfter() {
        System.out.print("");
    }
}
