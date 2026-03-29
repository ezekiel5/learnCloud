package de.hainam.taskmanagement;

import de.hainam.taskmanagement.entities.Task;
import de.hainam.taskmanagement.repository.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTask() {
        return this.taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody final Task task) {
        return this.taskRepository.save(task);
    }
}
