package edu.eci.cvds.task_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("/taskManager")
public class taskController {

    @Autowired
    private TaskService taskService;
    @CrossOrigin(origins = "http://localhost:5500")
    @GetMapping("getTask")
    public Task getTask(@RequestParam String id){
        return taskService.getTask(id);
    }
    @CrossOrigin(origins = "http://localhost:5500")
    @PostMapping("saveTask")
    public void saveTask(@RequestBody Task task){
        taskService.saveTask(task);
    }
    @CrossOrigin(origins = "http://localhost:5500")
    @PutMapping("/{id}")
    public void updateTask(@PathVariable String id, @RequestBody Task task){
        taskService.updateTask(id, task);
    }
    @CrossOrigin(origins = "http://localhost:5500")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
    }

}

