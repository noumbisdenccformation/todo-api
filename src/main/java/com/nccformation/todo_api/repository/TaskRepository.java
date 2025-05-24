package com.nccformation.todo_api.repository;

import com.nccformation.todo_api.model.Task;
import com.nccformation.todo_api.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Permet de récupérer toutes les tâches avec un statut donné (filtrage)
    List<Task> findByStatus(TaskStatus status);
}
