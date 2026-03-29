package de.hainam.taskmanagement.entities;

import de.hainam.taskmanagement.entities.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Task() {}

    public Task(String title) {
        this.title = title;
        this.status = Status.TODO;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Status getStatus() { return status; }

    public void setTitle(String title) { this.title = title; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}