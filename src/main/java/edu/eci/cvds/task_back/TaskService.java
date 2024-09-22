package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskService {
    List<Task> tasks;
    HashMap<String,User> users = new HashMap<>();
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksByUser(String idUser) {
        return taskRepository.findTasksByUser(idUser);
    }
    public void createUser(User user){
        users.put(user.getId(),user);
    }

    public List<User> getUsers(){
        List<User> newUser= new ArrayList<>();
        for(String user : users.keySet()){
            newUser.add(users.get(user));
        }
        return newUser;
    }
    public Task getTask(String id){
        return taskRepository.findById(id).orElse(null);
    }
    public void saveTask(Task task){
        if (users.containsKey(task.getIdUser())){
            taskRepository.save(task);
        }
    }
    public void updateTask(String id, Task task){
        Task taskRepo = getTask(id);
        if (taskRepo != null){
            taskRepository.save(task);
        }
    }
    public void deleteTask(String id){
        Task taskRepo = getTask(id);
        if (taskRepo != null){
            taskRepository.delete(taskRepo);
        }
    }
}
