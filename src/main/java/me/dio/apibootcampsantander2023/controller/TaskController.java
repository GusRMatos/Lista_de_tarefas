package me.dio.apibootcampsantander2023.controller;

import me.dio.apibootcampsantander2023.model.Task;
import me.dio.apibootcampsantander2023.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task taskToCreate){
        var taskCreated = taskService.create(taskToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(taskCreated.getId()).toUri();
        return ResponseEntity.created(location).body(taskCreated);
    }

    @GetMapping
    public List<Task> listAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id){
        var task = taskService.findByid(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task updatedTaskEntity = taskService.update(id, updatedTask);
        return ResponseEntity.ok(updatedTaskEntity);
    }
}
