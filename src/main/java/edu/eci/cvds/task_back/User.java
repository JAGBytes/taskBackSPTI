package edu.eci.cvds.task_back;

import java.util.List;

public class User {

    private String id;
    private List<Task> tasks;

    public List<Task> getTasks(){
        return tasks;
    }

    public User(String id){
        this.id=id;
    }

    public String getId(){
        return id;
    }


}
