package com.mike.patterns.behavioral.templateMethod;

public class Facebook extends SocialNetwork {

    public Facebook(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("Check parameters user " + username);
        System.out.println("Login: " + username);
        System.out.print("Password: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkConnection();
        System.out.println("\nUser " + username + " login successfully!");
        return true;
    }

    @Override
    public boolean sendData(byte[] message) {
        System.out.println("User " + username + " posted '" + new String(message) + "' in the Facebook");
        return true;
    }

    @Override
    public void logOut() {
        System.out.println("Username " + username + " was successfully logOut!");
    }

    private void simulateNetworkConnection() {
        try {
            System.out.println();
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
