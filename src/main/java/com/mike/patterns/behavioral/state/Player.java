package com.mike.patterns.behavioral.state;

public class Player {
    private boolean playing;
    private State state;

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void changeState() {
        if (this.state instanceof StopState) {
            this.setState(new PlayState());
        } else {
            this.setState(new StopState());
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void startAction() {
        this.state.pressPlay(this);
    }
}
