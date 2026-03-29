package de.hainam.taskmanagement.entities.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(final String exception) {
        super(exception);
    }
}
