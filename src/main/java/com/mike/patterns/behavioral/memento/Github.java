package com.mike.patterns.behavioral.memento;

public class Github {
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}
