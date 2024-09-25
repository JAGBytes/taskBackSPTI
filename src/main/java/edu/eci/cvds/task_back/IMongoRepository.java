package edu.eci.cvds.task_back;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface IMongoRepository extends MongoRepository<Task, String>, IRepository {
}
