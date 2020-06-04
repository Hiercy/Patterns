package com.mike.patterns.structural.proxy;

public class Client {
    public static void main(String[] args) {
        PyaterochkaProxy pyaterochkaProxy = new PyaterochkaProxy(new PyaterochkaShop());
        pyaterochkaProxy.enter(new User("Mike"));
        pyaterochkaProxy.enter(new User("Bob"));
        pyaterochkaProxy.enter(new User("John"));
        pyaterochkaProxy.enter(new User("Den"));
        pyaterochkaProxy.enter(new User("Coal"));
    }
}
