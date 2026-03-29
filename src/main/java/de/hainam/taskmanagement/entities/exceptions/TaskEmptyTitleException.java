package de.hainam.taskmanagement.entities.exceptions;

public class TaskEmptyTitleException extends RuntimeException {
    public TaskEmptyTitleException(final String message) {
        super(message);
    }
}