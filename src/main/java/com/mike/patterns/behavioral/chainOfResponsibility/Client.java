package com.mike.patterns.behavioral.chainOfResponsibility;

import com.mike.patterns.behavioral.chainOfResponsibility.handlers.AbstractErrorHandler;
import com.mike.patterns.behavioral.chainOfResponsibility.handlers.FirstHandler;
import com.mike.patterns.behavioral.chainOfResponsibility.handlers.Number;
import com.mike.patterns.behavioral.chainOfResponsibility.handlers.SecondHandler;
import com.mike.patterns.behavioral.chainOfResponsibility.handlers.ThirdHandler;

public class Client {

    public static void main(String[] args) {

        AbstractErrorHandler errorHandler = new FirstHandler();
        errorHandler.linkWith(new SecondHandler()).linkWith(new ThirdHandler());

        com.mike.patterns.behavioral.chainOfResponsibility.handlers.Number numberHandler = new Number();
        numberHandler.setErrorHandler(errorHandler);

        String reuslt = numberHandler.startChain("first");
        System.out.println(reuslt);
        reuslt = numberHandler.startChain("second");
        System.out.println(reuslt);
        reuslt = numberHandler.startChain("third");
        System.out.println(reuslt);
        reuslt = numberHandler.startChain("some text");
        System.out.println(reuslt);
    }
}
