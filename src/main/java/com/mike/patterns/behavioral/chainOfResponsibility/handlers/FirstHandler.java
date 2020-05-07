package com.mike.patterns.behavioral.chainOfResponsibility.handlers;

public class FirstHandler extends AbstractErrorHandler {
    @Override
    public String sendError(String message) {
        if (message.equals("first")) {
            System.out.println("First");
            return "Error from first";
        }
        return sendErrorNext(message);
    }
}
