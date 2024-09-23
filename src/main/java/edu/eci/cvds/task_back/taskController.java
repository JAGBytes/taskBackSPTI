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
    @PostMapping("saveTask")
    public void saveTask(@RequestBody Task task){
        taskService.saveTask(task);
    }
    @CrossOrigin(origins = "*")
    @PatchMapping("/markTaskAsCompleted")
    public void markTaskAsCompleted(@RequestParam String id){
        taskService.markTaskAsCompleted(id);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam String id){
        taskService.deleteTask(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("getTasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

}

