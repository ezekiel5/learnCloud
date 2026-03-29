package de.hainam.taskmanagement;

import de.hainam.taskmanagement.entities.Task;
import de.hainam.taskmanagement.repositories.TaskRepository;
import de.hainam.taskmanagement.services.TaskService;
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
    public Task addTask(@RequestBody final Task task) {
        return this.taskService.createTask(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return this.taskService.getTaskById(id);
    }
}
