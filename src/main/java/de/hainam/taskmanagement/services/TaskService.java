package de.hainam.taskmanagement.services;

import de.hainam.taskmanagement.entities.Task;
import de.hainam.taskmanagement.entities.enums.Status;
import de.hainam.taskmanagement.entities.exceptions.TaskEmptyTitleException;
import de.hainam.taskmanagement.entities.exceptions.TaskNotFoundException;
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
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new TaskEmptyTitleException("Fail create task: Title cannot be empty");
        }

        task.setStatus(Status.TODO);
        return this.taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found: " + id));
    }

    public Task updateTask(final Long id, final Task task) {
        final Task existing = getTaskById(id);
        existing.setTitle(task.getTitle());
        // status need set by rest and not from here
        return taskRepository.save(existing);
    }

    public Task deleteTask(final Long id) {
        final Task existing = getTaskById(id);
        taskRepository.delete(existing);
        return existing;
    }
}