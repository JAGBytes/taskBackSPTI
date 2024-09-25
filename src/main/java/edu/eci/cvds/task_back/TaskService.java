package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(@Qualifier("mongo_repository") TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Task getTask(String id){
        return taskRepository.findTaskById(id);
    }
    public List<Task> getTasks(){
        return taskRepository.findAllTasks();
    }
    public void saveTask(Task task){
        taskRepository.saveTask(task);
    }
    public void markTaskAsCompleted(String id){
        Task taskRepo = getTask(id);
        if (taskRepo != null){
            taskRepo.setIsCompleted(true);
            taskRepository.saveTask(taskRepo);
        }
    }
    public void deleteTask(String id){
        Task taskRepo = getTask(id);
        if (taskRepo != null){
            taskRepository.deleteTask(taskRepo);
        }
    }
}
