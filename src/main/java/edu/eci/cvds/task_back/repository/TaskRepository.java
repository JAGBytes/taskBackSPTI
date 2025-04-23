package edu.eci.cvds.task_back.repository;


import edu.eci.cvds.task_back.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{
}
