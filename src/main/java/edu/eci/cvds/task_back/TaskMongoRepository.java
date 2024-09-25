package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("mongo_repository")
public class TaskMongoRepository extends TaskRepository{

    @Autowired
    public TaskMongoRepository(IMongoRepository mongo){
        super(mongo);
    }

    public void saveTask(Task task){
        ((IMongoRepository)repository).save(task);
    }
    public List<Task> findAllTasks(){
        return ((IMongoRepository)repository).findAll();
    }
    public void deleteTask(Task task){
        ((IMongoRepository)repository).deleteTask(task);
    }
    public Task findTaskById(String id){
        return ((IMongoRepository)repository).findById(id).orElse(null);
    }
}
