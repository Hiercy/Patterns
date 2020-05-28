package com.mike.patterns.structural.composite;

public class Client {
    public static void main(String[] args) {
        LetterComposite starWars = new Messenger().messageFromStarWars();
        System.out.println(starWars.count());
        starWars.print();

        LetterComposite schwarz = new Messenger().messageFromSchwarzenegger();
        System.out.println(schwarz.count());
        schwarz.print();

        LetterComposite joker = new Messenger().messageFromJoker();
        System.out.println(joker.count());
        joker.print();
    }
}
