package com.mike.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class JobSite implements Publisher {
    List<Listener> listenerList = new ArrayList<>();
    List<String> vacancies = new ArrayList<>();

    public void addVacancy(String vacancy) {
        this.vacancies.add(vacancy);
        this.notifyListeners();
    }

    public void deleteVacancy(String vacancy) {
        this.vacancies.remove(vacancy);
        this.notifyListeners();
    }

    @Override
    public void subscribe(Listener listener) {
        this.listenerList.add(listener);
    }

    @Override
    public void unsubscribe(Listener listener) {
        this.listenerList.remove(listener);
    }

    @Override
    public void notifyListeners() {
        for (Listener listener : listenerList) {
            listener.handleEvent(vacancies);
        }
    }

    @Override
    public String toString() {
        return "JobSite:\n" +
                "listenerList=" + listenerList +
                ", vacancies=" + vacancies +
                '}';
    }
}
