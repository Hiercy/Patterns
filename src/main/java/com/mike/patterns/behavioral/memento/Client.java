package com.mike.patterns.behavioral.memento;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Project coolProject = new Project();
        Github github = new Github();

        coolProject.setProjectName("New Cool Project Name");
        coolProject.setCommitAndVersion("First commit", "Version 1.0");
        System.out.println(coolProject);
        github.setSave(coolProject.save());

        Thread.sleep(5000);

        System.out.println("Write new feature");
        System.out.println("Commit and push to github");
        coolProject.setCommitAndVersion("Added new cool feature", "Version 1.1");
        System.out.println(coolProject);

        Thread.sleep(5000);

        System.out.println("Bad updated. Need to roll back");
        coolProject.load(github.getSave());
        System.out.println("Rolling back...");

        System.out.println(coolProject);
    }
}
