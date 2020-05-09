package com.mike.patterns.behavioral.state;

public class LockedState implements State {
    @Override
    public void pressPlay(Player player) {
        if (player.isPlaying()) {
            System.out.println("Now player is playing. Stop music");
            player.setState(new StopState());
        } else {
            System.out.println("Start player");
            player.setState(new PlayState());
        }
    }
}
