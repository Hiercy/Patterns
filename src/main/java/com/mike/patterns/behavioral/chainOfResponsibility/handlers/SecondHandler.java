package com.mike.patterns.behavioral.chainOfResponsibility.handlers;

public class SecondHandler extends AbstractErrorHandler {
    @Override
    public String sendError(String message) {
        if (message.equals("second")) {
            System.out.println("Second");
            return "Error from second";
        }
        return sendErrorNext(message);
    }
}
