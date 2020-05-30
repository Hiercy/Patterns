package com.mike.patterns.structural.facade;

public class Task {

    private final int index;
    private final TaskType taskType;
    private final String title;
    private final String description;
    private final User assignee;
    private final User reporter;
    private final PriorityType priorityType;

    public int getIndex() {
        return index;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignee() {
        return assignee;
    }

    public User getReporter() {
        return reporter;
    }

    public PriorityType getPriorityType() {
        return priorityType;
    }

    public static class Builder {
        private final int index;
        private final String title;

        private TaskType taskType;
        private String description;
        private User assignee;
        private User reporter;
        private PriorityType priorityType;

        public Builder(int index, String title) {
            this.index = index;
            this.title = title;
        }

        public Builder setTaskType(TaskType taskType) {
            this.taskType = taskType;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAssignee(User assignee) {
            this.assignee = assignee;
            return this;
        }

        public Builder setReporter(User reporter) {
            this.reporter = reporter;
            return this;
        }

        public Builder setPriorityType(PriorityType priorityType) {
            this.priorityType = priorityType;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    private Task(Builder builder) {
        this.index = builder.index;
        this.taskType = builder.taskType;
        this.title = builder.title;
        this.description = builder.description;
        this.assignee = builder.assignee;
        this.reporter = builder.reporter;
        this.priorityType = builder.priorityType;
    }

    @Override
    public String toString() {
        return "Task{" +
                "index=" + index +
                ", taskType=" + taskType +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignee=" + assignee +
                ", reporter=" + reporter +
                ", priorityType=" + priorityType +
                '}';
    }
}
