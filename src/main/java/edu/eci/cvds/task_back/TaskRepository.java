package edu.eci.cvds.task_back;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    @Query("{idUser:'?0'}")
    List<Task> findTasksByUser(String idUser);


}
