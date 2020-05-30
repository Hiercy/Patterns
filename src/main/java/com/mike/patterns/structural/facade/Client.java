package com.mike.patterns.structural.facade;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        User manager = new User("John");
        User developerA = new User("Mike");
        User developerB = new User("Bob");
        User developerC = new User("Coal");
        TaskManager taskManager = new TaskManager(manager);

        taskManager.createEpic("New project", "Need to realize new project", PriorityType.HIGHEST, developerA);
        taskManager.createStory("New feature", "Need to realize new cool feature", PriorityType.MEDIUM, developerB);
        taskManager.createSimpleTask("New task", "Need to realize concrete stuff", PriorityType.HIGH, developerC);
        taskManager.createSimpleTask("New task", "Buy coffee", PriorityType.LOWEST, manager);
        taskManager.createBug("New bug", "Need to fix bug", PriorityType.LOW, developerB);

        System.out.println("Count of active task = " + taskManager.countOfActiveTasks());

        Task activeTask = taskManager.getActiveTaskByName("New bug");
        if (activeTask != null) {
            taskManager.closeTask(activeTask.getIndex());
            System.out.println("Task '" + activeTask.getTitle() + "' with id " + activeTask.getIndex() + " with priority " + activeTask.getPriorityType() + " with reporter " + activeTask.getReporter().getName() + " was closed!");
            System.out.println("Count of closed task = " + taskManager.countOfClosedTasks());
        }
        System.out.println("Count of active task = " + taskManager.countOfActiveTasks());

        activeTask = taskManager.getActiveTaskById(3);
        if (activeTask != null) {
            taskManager.closeTask(3);
            System.out.println("Task '" + activeTask.getTitle() + "' with id " + activeTask.getIndex() + " with priority " + activeTask.getPriorityType() + " with reporter " + activeTask.getReporter().getName() + " was closed!");
            System.out.println("Count of closed task = " + taskManager.countOfClosedTasks());
        }
        System.out.println("Count of active task = " + taskManager.countOfActiveTasks());

        Task closedTask = taskManager.getClosedTaskById(0);
        System.out.println("Closed task '" + closedTask.getTitle() + "' with id " + closedTask.getIndex() + " with priority " + closedTask.getPriorityType());

        closedTask = taskManager.getClosedTaskByName("New task");
        System.out.println("Closed task '" + closedTask.getTitle() + "' with id " + closedTask.getIndex() + " with priority " + closedTask.getPriorityType());

        // If you don't want to use the facade pattern
        List<Task> tasks = List.of(
                new Task.Builder(0, "New project")
                        .setDescription("Need to realize new project")
                        .setPriorityType(PriorityType.HIGHEST)
                        .setTaskType(TaskType.EPIC)
                        .setAssignee(manager)
                        .setReporter(developerA)
                        .build(),
                new Task.Builder(1, "New feature")
                        .setDescription("Need to realize new cool feature")
                        .setPriorityType(PriorityType.MEDIUM)
                        .setTaskType(TaskType.STORY)
                        .setAssignee(manager)
                        .setReporter(developerB)
                        .build(),
                new Task.Builder(2, "New task")
                        .setDescription("Need to realize concrete stuff")
                        .setPriorityType(PriorityType.HIGH)
                        .setTaskType(TaskType.TASK)
                        .setAssignee(manager)
                        .setReporter(developerC)
                        .build(),
                new Task.Builder(3, "New task")
                        .setDescription("Buy coffee")
                        .setPriorityType(PriorityType.LOWEST)
                        .setTaskType(TaskType.TASK)
                        .setAssignee(manager)
                        .setReporter(manager)
                        .build(),
                new Task.Builder(4, "New bug")
                        .setDescription("Need to fix bug")
                        .setPriorityType(PriorityType.LOW)
                        .setTaskType(TaskType.BUG)
                        .setAssignee(manager)
                        .setReporter(developerB)
                        .build()
        );

        TaskManager newTaskManager = new TaskManager(tasks, manager);
        System.out.println("Count of new active tasks = " + newTaskManager.countOfActiveTasks());
    }
}

