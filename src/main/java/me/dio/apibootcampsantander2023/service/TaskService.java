package me.dio.apibootcampsantander2023.service;

import me.dio.apibootcampsantander2023.model.Task;
import me.dio.apibootcampsantander2023.repository.TaskRepository;

import java.util.List;

public interface TaskService {

    Task create(Task taskToCreate);

    List<Task> findAll();

    Task findByid(Long id);

    Task update(Long id, Task entity);

    void delete(Long id);


}
