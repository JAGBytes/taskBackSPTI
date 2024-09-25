package edu.eci.cvds.task_back;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TaskControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TaskService taskService;

    @InjectMocks
    private taskController taskController;

    private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();

        task1 = new Task("1", "Test Task 1", "Description 1", LocalDate.now().plusDays(1));
        task2 = new Task("2", "Test Task 2", "Description 2", LocalDate.now().plusDays(2));
    }

    @Test
    public void testSaveTask() throws Exception {
        mockMvc.perform(post("/taskManager/saveTask")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\", \"name\":\"Test Task 1\", \"description\":\"Description 1\", \"dueDate\":\"2024-12-31\"}"))
                .andExpect(status().isOk());

        verify(taskService, times(1)).saveTask(any(Task.class));
    }

    @Test
    public void testMarkTaskAsCompleted() throws Exception {
        mockMvc.perform(patch("/taskManager/markTaskAsCompleted")
                        .param("id", "1"))
                .andExpect(status().isOk());

        verify(taskService, times(1)).markTaskAsCompleted("1");
    }

    @Test
    public void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/taskManager/delete")
                        .param("id", "1"))
                .andExpect(status().isOk());

        verify(taskService, times(1)).deleteTask("1");
    }

    @Test
    public void testGetTasks() throws Exception {
        List<Task> tasks = Arrays.asList(task1, task2);
        when(taskService.getTasks()).thenReturn(tasks);

        mockMvc.perform(get("/taskManager/getTasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Task 1"))
                .andExpect(jsonPath("$[1].name").value("Test Task 2"));

        verify(taskService, times(1)).getTasks();
    }
}