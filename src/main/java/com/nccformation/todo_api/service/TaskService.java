package com.nccformation.todo_api.service;

import com.nccformation.todo_api.model.Task;
import com.nccformation.todo_api.model.TaskStatus;
import com.nccformation.todo_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // ◦ createTask()
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // ◦ getAllTasks()
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ◦ getTasksByStatus(TaskStatus status)
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    // ◦ updateTask(Long id, Task task)
    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            return taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Tâche non trouvée avec ID : " + id);
        }
    }

    // ◦ deleteTask(Long id)
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
