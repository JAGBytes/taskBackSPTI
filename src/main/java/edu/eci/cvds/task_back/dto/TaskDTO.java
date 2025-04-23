package edu.eci.cvds.task_back.dto;

import java.time.LocalDate;

public class TaskDTO {
    private String id;
    private String name;
    private String description;
    private String dueDate;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

  
}
