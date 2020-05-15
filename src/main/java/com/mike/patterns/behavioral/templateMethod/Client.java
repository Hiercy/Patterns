package com.mike.patterns.behavioral.templateMethod;

import java.util.Random;

public class Client {

    private final static String[] MESSAGES = {
            "Failure will never overtake me if my determination to succeed is strong enough.",
            "The pleasure of love is in loving.",
            "What makes something special is not just what you have to gain, but what you feel there is to lose.",
            "Just because something doesn't do what you planned it to do doesn't mean it's useless.",
            "How we treasure (and admire) the people who acknowledge us!",
            "Science is nothing but developed perception, interpreted intent, common sense rounded out and minutely articulated.",
            "Always acknowledge a fault. This will throw those in authority off their guard and give you an opportunity to commit more.",
            "A good man would prefer to be defeated than to defeat injustice by evil means.",
            "To see what is right and not to do it is want of courage.",
            "You don’t remember what happened. What you remember becomes what happened."
    };

    public static void main(String[] args) {
        String username = "Hiercy";
        String password = "123456789qwerty";

        SocialNetwork facebook = new Facebook(username, password);
        SocialNetwork vk = new Vkontakte(username, password);
        Random random = new Random();

        for (int i = 0; i < MESSAGES.length; i++) {
            int index = random.nextInt(10);
            String message = MESSAGES[index];
            System.out.println("FACEBOOK");
            facebook.postMessage(message);
            System.out.println("==================");
            System.out.println("VKONTAKTE");
            vk.postMessage(message);
            System.out.println("==================");
        }
    }
}
