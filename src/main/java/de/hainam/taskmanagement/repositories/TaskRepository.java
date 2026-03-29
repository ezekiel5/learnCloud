package de.hainam.taskmanagement.repositories;

import de.hainam.taskmanagement.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
