package de.hainam.taskmanagement;

import de.hainam.taskmanagement.entities.Task;
import de.hainam.taskmanagement.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository) {

        return args -> {
            taskRepository.save(new Task("Test task"));

            taskRepository.findAll().forEach(task -> log.info("Preloaded " + task));
        };
    }
}
