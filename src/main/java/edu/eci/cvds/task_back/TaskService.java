package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskService {
    List<Task> tasks ;
    HashMap<String,User> users;
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksByUser(String idUser) {
        return taskRepository.findTasksByUser(idUser);
    }
    public void createUser(User usuario){
        users.put(usuario.getId(),usuario);

    }

    public List<User> getUsers(){
        List<User> newUser= new ArrayList<>();
        for(String user : users.keySet()){
            newUser.add(users.get(user));
        }
        return newUser;
    }
}
