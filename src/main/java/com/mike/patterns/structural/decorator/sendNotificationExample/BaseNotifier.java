package com.mike.patterns.structural.decorator.sendNotificationExample;

public class BaseNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Send message to email = " + message);
    }
}
