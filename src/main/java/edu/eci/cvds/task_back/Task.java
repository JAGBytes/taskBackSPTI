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
    private LocalDate dueDate;
    private LocalDate creationDate;
    private Boolean isCompleted = false;

    public Task(String id, String name, String description, LocalDate dueDate) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = LocalDate.now();
        this.dueDate = dueDate;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }
    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
