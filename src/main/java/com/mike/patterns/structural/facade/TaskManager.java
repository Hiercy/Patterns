package com.mike.patterns.structural.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Facade for complex structure
public class TaskManager {

    private final List<Task> activeTasks = new ArrayList<>();
    private final List<Task> closedTask = new ArrayList<>();
    private final User reporter;
    private final AtomicInteger index = new AtomicInteger(0);

    public TaskManager(User reporter) {
        this.reporter = reporter;
    }

    public TaskManager(List<Task> activeTasks, User reporter) {
        activeTasks.forEach(this::addTask);
        this.reporter = reporter;
    }

    public void addTask(Task task) {
        activeTasks.add(task);
    }

    public void closeTask(int id) {
        Task task = activeTasks.get(id - 1);
        closedTask.add(task);
        activeTasks.remove(task);
    }

    public int countOfActiveTasks() {
        return activeTasks.size();
    }

    public int countOfClosedTasks() {
        return closedTask.size();
    }

    public Task getActiveTaskById(int id) {
        return activeTasks.get(id - 1);
    }

    public Task getActiveTaskByName(String title) {
        for (Task task : activeTasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    public Task getClosedTaskById(int id) {
        return closedTask.get(id);
    }

    public Task getClosedTaskByName(String title) {
        for (Task task : closedTask) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    public void createSimpleTask(String title, String desc, PriorityType priorityType, User assignee) {
        Task task = new Task.Builder(index.incrementAndGet(), title)
                .setDescription(desc)
                .setTaskType(TaskType.TASK)
                .setPriorityType(priorityType)
                .setAssignee(assignee)
                .setReporter(reporter)
                .build();
        addTask(task);
    }

    public void createBug(String title, String desc, PriorityType priorityType, User assignee) {
        Task task = new Task.Builder(index.incrementAndGet(), title)
                .setDescription(desc)
                .setTaskType(TaskType.BUG)
                .setPriorityType(priorityType)
                .setAssignee(assignee)
                .setReporter(reporter)
                .build();
        addTask(task);
    }

    public void createStory(String title, String desc, PriorityType priorityType, User assignee) {
        Task task = new Task.Builder(index.incrementAndGet(), title)
                .setDescription(desc)
                .setTaskType(TaskType.STORY)
                .setPriorityType(priorityType)
                .setAssignee(assignee)
                .setReporter(reporter)
                .build();
        addTask(task);
    }

    public void createEpic(String title, String desc, PriorityType priorityType, User assignee) {
        Task task = new Task.Builder(index.incrementAndGet(), title)
                .setDescription(desc)
                .setTaskType(TaskType.EPIC)
                .setPriorityType(priorityType)
                .setAssignee(assignee)
                .setReporter(reporter)
                .build();
        addTask(task);
    }
}
