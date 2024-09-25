package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Task getTask(String id){
        return taskRepository.findById(id).orElse(null);
    }
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    public void saveTask(Task task){
        taskRepository.save(task);
    }
    public void markTaskAsCompleted(String id){
        Task taskRepo = getTask(id);
        taskRepo.setIsCompleted(true);
        if (taskRepo != null){
            taskRepository.save(taskRepo);
        }
    }
    public void deleteTask(String id){
        Task taskRepo = getTask(id);
        if (taskRepo != null){
            taskRepository.delete(taskRepo);
        }
    }
}
