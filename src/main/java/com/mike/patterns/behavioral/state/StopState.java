package com.mike.patterns.behavioral.state;

public class StopState implements State {

    @Override
    public void pressPlay(Player player) {
        if (player.isPlaying()) {
            player.setPlaying(false);
            System.out.println("Stop playing");
            player.setState(this);
        } else {
            System.out.println("Cannot stop playing twice");
        }
    }
}
