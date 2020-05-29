package com.mike.patterns.structural.decorator.sendNotificationExample;

public class FacebookNotifier extends BaseNotifier {

    private Notifier decorator;

    public FacebookNotifier(Notifier decorator) {
        this.decorator = decorator;
    }

    @Override
    public void send(String message) {
        System.out.println("Send message to facebook = " + message);
        decorator.send(message);
    }
}
