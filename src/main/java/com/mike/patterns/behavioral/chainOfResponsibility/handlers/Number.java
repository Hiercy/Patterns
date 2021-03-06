package com.mike.patterns.behavioral.chainOfResponsibility.handlers;

public class Number {
    private AbstractErrorHandler errorHandler;

    public String startChain(String number) {
        return errorHandler.sendError(number);
    }

    public void setErrorHandler(AbstractErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }
}
