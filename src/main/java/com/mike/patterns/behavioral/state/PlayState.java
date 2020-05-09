package com.mike.patterns.behavioral.state;

public class PlayState implements State {

    @Override
    public void pressPlay(Player player) {
        if (player.isPlaying()) {
            System.out.println("Cannot start playing twice");
        } else {
            player.setPlaying(true);
            System.out.println("Start playing");
            player.setState(this);
        }
    }
}
