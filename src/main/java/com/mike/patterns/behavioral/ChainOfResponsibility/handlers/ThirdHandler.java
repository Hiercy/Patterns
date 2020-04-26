package com.mike.patterns.behavioral.ChainOfResponsibility.handlers;

public class ThirdHandler extends AbstractErrorHandler {
    @Override
    public String sendError(String message) {
        if (message.equals("third")) {
            System.out.println("Third");
            return "Error from third";
        }
        return sendErrorNext(message);
    }
}
