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
    @CrossOrigin(origins = "*")
    @GetMapping("getTask")
    public Task getTask(@RequestParam String id){
        return taskService.getTask(id);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("saveTask")
    public void saveTask(@RequestBody Task task){
        taskService.saveTask(task);
    }
    @CrossOrigin(origins = "*")
    @PatchMapping("/{id}")
    public void updateTask(@PathVariable String id, @RequestBody Task task){
        taskService.updateTask(id, task);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("getTasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

}

