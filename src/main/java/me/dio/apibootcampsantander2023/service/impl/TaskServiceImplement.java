package me.dio.apibootcampsantander2023.service.impl;

import me.dio.apibootcampsantander2023.model.Task;
import me.dio.apibootcampsantander2023.repository.TaskRepository;
import me.dio.apibootcampsantander2023.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImplement implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImplement(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task taskToCreate) {
        if(taskRepository.existsById(taskToCreate.getId())){
            throw new IllegalArgumentException("Um usuario com esse id ja existe");
        }
        return taskRepository.save(taskToCreate);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findByid(Long id) {
        return taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Task update(Long id, Task entity) {
        Task taskToUpdate = taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
        taskToUpdate.setTitle(entity.getTitle());
        taskToUpdate.setDescription(entity.getDescription());
        taskToUpdate.setDueDate(entity.getDueDate());
        taskToUpdate.setPriority(entity.getPriority());
        taskToUpdate.setCompleted(entity.isCompleted());

        return taskRepository.save(taskToUpdate);
    }

    @Override
    public void delete(Long id) {
        taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
        taskRepository.deleteById(id);
    }
}
