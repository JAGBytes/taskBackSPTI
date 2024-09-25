package edu.eci.cvds.task_back;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component("text_repository")
public class TaskTextRepository extends TaskRepository{
    private final String filePath = "../resources/tasks.json"; // Ruta del archivo JSON
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public TaskTextRepository(ITextRepository text){
        super(text);
    }

    public void saveTask(Task task) {
        List<Task> tasks = findAllTasks();
        tasks.add(task);
        saveAllTasks(tasks);
    }

    public List<Task> findAllTasks() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public void deleteTask(Task task) {
        List<Task> tasks = findAllTasks();
        tasks.removeIf(t -> t.getId().equals(task.getId()));
        saveAllTasks(tasks);
    }


    public Task findTaskById(String id) {
        return findAllTasks().stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private void saveAllTasks(List<Task> tasks) {
        try {
            objectMapper.writeValue(new File(filePath), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
