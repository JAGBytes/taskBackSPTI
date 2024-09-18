package edu.eci.cvds.task_back;

import java.util.List;

public class User {

    private String id;
    private String name;
    private String email;

    private List<Task> tasks;

    // Getter y setter para tasks
    public List<Task> getTasks(){
        return tasks;
    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    // Getter y setter para id
    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter y setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
