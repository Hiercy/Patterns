package com.mike.patterns.structural.decorator.sendNotificationExample;

public class Client {
    public static void main(String[] args) {
        System.out.println("=== Send to email ===");
        Notifier baseNotifier = new BaseNotifier();
        baseNotifier.send("Email");

        System.out.println("\n=== Send to facebook ===");
        Notifier facebook = new FacebookNotifier(new BaseNotifier());
        facebook.send("Facebook and Email");

        System.out.println("\n=== Send to three platforms ===");
        Notifier smsAndFacebook = new SmsNotifier(new FacebookNotifier(new BaseNotifier()));
        smsAndFacebook.send("Sms Facebook and Email");

        System.out.println("\n=== Send sms and email ===");
        Notifier smsAndEmail = new SmsNotifier(baseNotifier);
        smsAndEmail.send("Sms and email");
    }
}
