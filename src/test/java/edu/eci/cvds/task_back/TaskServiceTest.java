package edu.eci.cvds.task_back;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    /*@Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTask() {
        Task task = new Task("1", "Test Task", "Description", LocalDate.now().plusDays(1));

        when(taskRepository.findById("1")).thenReturn(Optional.of(task));

        Task result = taskService.getTask("1");

        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Test Task", result.getName());
    }

    @Test
    public void testGetTasks() {
        Task task1 = new Task("1", "Test Task 1", "Description 1", LocalDate.now().plusDays(1));
        Task task2 = new Task("2", "Test Task 2", "Description 2", LocalDate.now().plusDays(2));

        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getTasks();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Test Task 1", result.get(0).getName());
        assertEquals("Test Task 2", result.get(1).getName());
    }

    @Test
    public void testSaveTask() {
        Task task = new Task("1", "Test Task", "Description", LocalDate.now().plusDays(1));

        taskService.saveTask(task);

        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testMarkTaskAsCompleted() {
        Task task = new Task("1", "Test Task", "Description", LocalDate.now().plusDays(1));
        task.setIsCompleted(false);

        when(taskRepository.findById("1")).thenReturn(Optional.of(task));

        taskService.markTaskAsCompleted("1");

        assertTrue(task.getIsCompleted());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1", "Test Task", "Description", LocalDate.now().plusDays(1));

        when(taskRepository.findById("1")).thenReturn(Optional.of(task));

        taskService.deleteTask("1");

        verify(taskRepository, times(1)).delete(task);
    }*/
}