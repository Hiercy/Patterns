package com.mike.patterns.behavioral.state;

public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        player.setPlaying(true);
        player.setState(new StopState());
        for (int i = 0; i <= 10; i++) {
            player.startAction();
            player.changeState();
        }
    }
}
