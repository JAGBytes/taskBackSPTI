package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Value("${task.repository.type}")
    private String repositoryType;

    private final TaskMongoRepository taskMongoRepository;
    private final TaskTextRepository taskTextRepository;

    @Autowired
    public TaskConfig(TaskMongoRepository taskMongoRepository, TaskTextRepository taskTextRepository) {
        this.taskMongoRepository = taskMongoRepository;
        this.taskTextRepository = taskTextRepository;
    }

    @Bean
    public TaskRepository taskRepository() {
        if ("mongo".equalsIgnoreCase(repositoryType)) {
            return taskMongoRepository;
        } else if ("text".equalsIgnoreCase(repositoryType)) {
            return taskTextRepository;
        } else {
            throw new IllegalArgumentException("Tipo de repositorio no soportado");
        }
    }
}
