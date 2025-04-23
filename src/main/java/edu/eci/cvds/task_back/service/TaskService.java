package edu.eci.cvds.task_back.service;

import org.springframework.stereotype.Service;

import edu.eci.cvds.task_back.model.Task;
import edu.eci.cvds.task_back.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio relacionada con las tareas.
 * Interactúa con un repositorio TaskRepository para realizar operaciones CRUD sobre las tareas.
 */
@Service
public class TaskService {
    private TaskRepository taskRepository;

    /**
     * Constructor que inyecta el repositorio de tareas mediante dependencia.
     * @param taskRepository El repositorio que se utilizará para la gestión de tareas.
     */
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Recupera una tarea por su ID.
     * @param id El identificador de la tarea.
     * @return La tarea encontrada o {@code null} si no existe.
     */
    public Optional<Task>  getTask(String id){
        return taskRepository.findById(id);
    }

    /**
     * Recupera todas las tareas almacenadas.
     * @return Lista de todas las tareas almacenadas.
     */
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    /**
     * Guarda una nueva tarea en el repositorio.
     * @param task La tarea a guardar.
     */
    public void saveTask(Task task){
        taskRepository.save(task);
    }

    /**
     * Marca una tarea como completada cambiando su estado.
     * @param id El identificador de la tarea a marcar como completada.
     */
    public void markTaskAsCompleted(String id){
        Task taskRepo = getTask(id).orElse(null);
        if (taskRepo != null){
            taskRepo.setIsCompleted(true);
            taskRepository.save(taskRepo);
        }
    }

    /**
     * Elimina una tarea del repositorio.
     * @param id El identificador de la tarea a eliminar.
     */
    public void deleteTask(String id){
        taskRepository.deleteById(id);
    }
}
