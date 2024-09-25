package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskMongoRepository extends TaskRepository,MongoRepository<Task,String>{

    @Override
    public default void saveTask(Task task){
        save(task);
    }
    @Override
    public default List<Task> findAllTasks(){
        return findAll();
    }
    @Override
    public default void deleteTask(Task task){
        delete(task);
    }
    @Override
    public default Task findTaskById(String id){
        return findById(id).orElse(null);
    }
}
