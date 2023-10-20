package me.dio.apibootcampsantander2023.repository;

import me.dio.apibootcampsantander2023.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
