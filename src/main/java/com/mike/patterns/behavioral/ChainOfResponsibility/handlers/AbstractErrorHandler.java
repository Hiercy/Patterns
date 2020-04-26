package com.mike.patterns.behavioral.ChainOfResponsibility.handlers;

public abstract  class AbstractErrorHandler {
    private AbstractErrorHandler nextHandler;

    public AbstractErrorHandler linkWith(AbstractErrorHandler errorHandler) {
        this.nextHandler = errorHandler;
        return nextHandler;
    }

    abstract String sendError(String message);

    public String sendErrorNext(String message) {
        if (nextHandler == null) {
            return message + " - not a number";
        }
        return nextHandler.sendError(message);
    }
}
