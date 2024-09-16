package edu.eci.cvds.task_back;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    @Query("{idUser:'?0'}")
    List<Task> findTasksByUser(String idUser);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Task> findAll(String category);

    public long count();

}
