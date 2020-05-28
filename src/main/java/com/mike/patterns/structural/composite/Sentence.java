package com.mike.patterns.structural.composite;

import java.util.List;

public class Sentence extends LetterComposite {

    public Sentence(List<Word> words) {
        words.forEach(this::add);
    }

    @Override
    public void printBefore() {
        System.out.print("");
    }

    @Override
    public void printAfter() {
        System.out.print(".\n");
    }
}
