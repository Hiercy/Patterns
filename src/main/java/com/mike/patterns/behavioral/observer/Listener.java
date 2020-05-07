package com.mike.patterns.behavioral.observer;

import java.util.List;

public interface Listener {
    void handleEvent(List<String> vacancies);
}
