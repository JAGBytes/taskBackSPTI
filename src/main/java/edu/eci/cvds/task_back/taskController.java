package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskManager")
public class taskController {
    @Autowired
    private TaskService taskService;


    @GetMapping ("getTasks")
    public List<Task> getTasks(@RequestParam String idUser) {
        return taskService.getTasksByUser(idUser);

    }

    @PostMapping ("createUser")
    public void createUser(@RequestBody User user){
        taskService.createUser(user);
    }
    @GetMapping ("getUsers")
    public List<User> getUsers(){
        return taskService.getUsers();
    }
}

