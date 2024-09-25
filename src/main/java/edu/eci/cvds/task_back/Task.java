package edu.eci.cvds.task_back;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document("tasks")
public class Task {

    @Id
    private String id;
    private String name;
    private String description;
    private String dueDate;
    private String creationDate;
    private Boolean isCompleted = false;

    // Constructor actualizado para incluir 'description'
    public Task(String id, String name, String description, String dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = LocalDate.now().toString();
        this.dueDate = dueDate;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setId(String id) {
        this.id = id;
    }
}

