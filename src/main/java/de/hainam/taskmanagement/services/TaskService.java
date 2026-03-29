package de.hainam.taskmanagement.services;

import de.hainam.taskmanagement.entities.Task;
import de.hainam.taskmanagement.entities.enums.Status;
import de.hainam.taskmanagement.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public Task createTask(final Task task) {
        task.setStatus(Status.TODO);
        return this.taskRepository.save(task);
    }

    public Task getTaskById(final Long id) {
        return this.taskRepository.findById(id).orElse(null);
    }
}