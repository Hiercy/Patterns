package com.mike.patterns.behavioral.templateMethod;

public abstract class SocialNetwork {

    String username;
    String password;

    public boolean postMessage(String message) {
        if (login(this.username, this.password)) {
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    public abstract boolean login(String username, String password);

    public abstract boolean sendData(byte[] message);

    public abstract void logOut();
}
