package com.mike.patterns.behavioral.observer;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        JobSite jobSiteName = new JobSite();
        List.of(
                "Junior Java Developer",
                "Middle Java Developer",
                "Senior Java Developer",
                "Diamond Java Developer"
        ).forEach(jobSiteName::addVacancy);

        Subscriber firstSubscriber = new Subscriber("Mike M");
        Subscriber secondSubscriber = new Subscriber("John J");
        Subscriber thirdSubscriber = new Subscriber("Bob B");

        jobSiteName.subscribe(firstSubscriber);
        jobSiteName.subscribe(secondSubscriber);
        jobSiteName.subscribe(thirdSubscriber);
        jobSiteName.addVacancy("Junior Python Developer");

        jobSiteName.unsubscribe(secondSubscriber);
        jobSiteName.deleteVacancy("Junior Python Developer");
    }
}
