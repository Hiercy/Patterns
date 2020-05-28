package com.mike.patterns.structural.composite;

import java.util.List;

public class Messenger {

    public LetterComposite messageFromSchwarzenegger() {
        List<Word> schwarzenegger = List.of(
                new Word('I', '\'', 'l', 'l'),
                new Word('b', 'e'),
                new Word('b', 'a', 'c', 'k')
        );
        return new Sentence(schwarzenegger);
    }

    public LetterComposite messageFromJoker() {
        List<Word> joker = List.of(
                new Word('W', 'h', 'y'),
                new Word('s', 'o'),
                new Word('s', 'e', 'r', 'i', 'o', 'u', 's')
        );
        return new Sentence(joker);
    }

    public LetterComposite messageFromStarWars() {
        List<Word> sw = List.of(
                new Word('M', 'a', 'y'),
                new Word('f', 'o', 'r', 'c', 'e'),
                new Word('w', 'i', 't', 'h'),
                new Word('y', 'o', 'u')
        );
        return new Sentence(sw);
    }
}
