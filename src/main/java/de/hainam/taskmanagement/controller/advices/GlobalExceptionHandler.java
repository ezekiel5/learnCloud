package de.hainam.taskmanagement.controller.advices;

import de.hainam.taskmanagement.entities.exceptions.TaskEmptyTitleException;
import de.hainam.taskmanagement.entities.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(TaskNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequest(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(TaskEmptyTitleException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleNotAcceptable(TaskEmptyTitleException ex) {
        return ex.getMessage();
    }
}