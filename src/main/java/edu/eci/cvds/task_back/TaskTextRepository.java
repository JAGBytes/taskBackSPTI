package edu.eci.cvds.task_back;

import java.util.List;

public interface TaskTextRepository {
    List<Task> findTasksByUser(String idUser);
}
