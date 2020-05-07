package com.mike.patterns.behavioral.observer;

public interface Publisher {
    void subscribe(Listener listener);

    void unsubscribe(Listener listener);

    void notifyListeners();
}
