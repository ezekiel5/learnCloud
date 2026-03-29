package de.hainam.taskmanagement;

import de.hainam.taskmanagement.entities.Task;
import de.hainam.taskmanagement.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository) {
        return args -> {
            // NOTE: multiple tasks untuk demo lebih menarik
            List<Task> tasks = List.of(
                    new Task("Setup project"),
                    new Task("Create REST API"),
                    new Task("Write tests")
            );

            // NOTE: batch save
            taskRepository.saveAll(tasks);

            // NOTE: log semua preloaded tasks
            taskRepository.findAll().forEach(task -> log.info("Preloaded " + task));
        };
    }
}