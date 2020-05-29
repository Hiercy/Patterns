package com.mike.patterns.structural.decorator.sendNotificationExample;

public class SmsNotifier extends BaseNotifier {

    private Notifier decorator;

    public SmsNotifier(Notifier decorator) {
        this.decorator = decorator;
    }

    @Override
    public void send(String message) {
        System.out.println("Send message to sms = " + message);
        decorator.send(message);
    }
}
