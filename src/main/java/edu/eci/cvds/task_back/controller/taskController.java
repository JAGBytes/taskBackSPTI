package edu.eci.cvds.task_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.eci.cvds.task_back.dto.TaskDTO;
import edu.eci.cvds.task_back.model.Task;
import edu.eci.cvds.task_back.service.TaskService;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones relacionadas con tareas.
 * Proporciona endpoints para crear, actualizar, eliminar y obtener tareas.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/taskManager")
public class taskController {

    @Autowired
    private TaskService taskService;

    /**
     * Endpoint para guardar una nueva tarea.
     * @param task Objeto de tipo Task recibido en el cuerpo de la solicitud.
     * Esta operación permite crear una nueva tarea.
     * La anotación {@code @CrossOrigin} permite solicitudes de origen cruzado de cualquier dominio.
     */

    @PostMapping("saveTask")
    public void saveTask(@RequestBody TaskDTO taskdto){
        Task task = new Task(taskdto.getId(), taskdto.getName(), taskdto.getDescription(), taskdto.getDueDate());

        taskService.saveTask(task);
    }

    /**
     * Endpoint para marcar una tarea como completada.
     * @param id Identificador de la tarea a marcar como completada, recibido como parámetro de solicitud.
     * Permite actualizar el estado de la tarea para indicar que ha sido completada.
     * La anotación {@code @CrossOrigin} permite solicitudes de origen cruzado de cualquier dominio.
     */

    @PatchMapping("/markTaskAsCompleted")
    public void markTaskAsCompleted(@RequestParam String id){
        taskService.markTaskAsCompleted(id);
    }

    /**
     * Endpoint para eliminar una tarea.
     * @param id Identificador de la tarea a eliminar, recibido como parámetro de solicitud.
     * Permite eliminar una tarea específica del sistema.
     * La anotación {@code @CrossOrigin} permite solicitudes de origen cruzado de cualquier dominio.
     */

    @DeleteMapping("/delete")
    public void deleteTask(@RequestParam String id){
        taskService.deleteTask(id);
    }

    /**
     * Endpoint para obtener todas las tareas.
     * @return Lista de tareas almacenadas en el sistema.
     * Permite obtener todas las tareas creadas. Las tareas se retornan en formato JSON.
     * La anotación {@code @CrossOrigin} permite solicitudes de origen cruzado de cualquier dominio.
     */
    @GetMapping("getTasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

}

