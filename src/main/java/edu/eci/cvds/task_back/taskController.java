package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class taskController {
    @Autowired
    private TaskService taskService;


    @GetMapping
    public List<Task> getTasks(@RequestParam String idUser) {
        return taskService.getTasksByUser(idUser);

    }

    @PostMapping
    public void createUser(@RequestBody User usuario){
        taskService.createUser(usuario);
    }

}
