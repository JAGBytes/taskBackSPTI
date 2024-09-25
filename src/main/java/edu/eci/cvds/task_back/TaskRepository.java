package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;
@Component
@Repository
public abstract class TaskRepository{
    public IRepository repository;

    @Autowired
    public TaskRepository(IRepository repository){
        this.repository = repository;
    }

    abstract void saveTask(Task task);
    abstract List<Task> findAllTasks();
    abstract void deleteTask(Task task);
    abstract Task findTaskById(String id);
}
