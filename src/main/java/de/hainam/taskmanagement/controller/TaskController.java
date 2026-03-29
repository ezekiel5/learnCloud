package de.hainam.taskmanagement.controller;

import de.hainam.taskmanagement.entities.Task;
import de.hainam.taskmanagement.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTask() {
        return this.taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody final Task task) {
        Task created = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return this.taskService.getTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody final Task task) {
        return this.taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable Long id) {
        return this.taskService.deleteTask(id);
    }
}
