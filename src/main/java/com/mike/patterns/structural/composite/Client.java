package com.mike.patterns.structural.composite;

public class Client {
    public static void main(String[] args) {
        LetterComposite starWars = new Messenger().messageFromStarWars();
        starWars.print();

        LetterComposite schwarz = new Messenger().messageFromSchwarzenegger();
        schwarz.print();

        LetterComposite joker = new Messenger().messageFromJoker();
        joker.print();
    }
}
