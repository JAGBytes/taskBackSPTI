package edu.eci.cvds.task_back;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TaskRepository {
    void saveTask(Task task);
    List<Task> findAllTasks();
    void deleteTask(Task task);
    Task findTaskById(String id);
}
