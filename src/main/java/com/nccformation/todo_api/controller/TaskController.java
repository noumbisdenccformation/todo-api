package com.nccformation.todo_api.controller;

import com.nccformation.todo_api.model.Task;
import com.nccformation.todo_api.model.TaskStatus;
import com.nccformation.todo_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ◦ POST / → créer une tâche
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // ◦ GET / → toutes les tâches
    @GetMapping
    public List<Task> getTasks(@RequestParam(required = false) TaskStatus status) {
        if (status != null) {
            return taskService.getTasksByStatus(status);
        }
        return taskService.getAllTasks();
    }

    // ◦ PUT /{id} → mise à jour
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    // ◦ DELETE /{id} → suppression
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
