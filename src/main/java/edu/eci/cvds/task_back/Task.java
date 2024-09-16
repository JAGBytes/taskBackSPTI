package edu.eci.cvds.task_back;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Document("tasks")
public class Task {

    @Id
    private String id;
    private String idUser;
    private String name;
    private String description;
    private LocalDate finalDate;
    private LocalDate creationDate;
    private Boolean isCompleted = false;

    public Task(String id,String idUser, String name, String description) {
        super();
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.description = description;
        this.creationDate = LocalDate.now();
    }
}
