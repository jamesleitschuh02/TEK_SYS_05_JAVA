package com.JamesLeitschuh.workspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JamesLeitschuh.workspace.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query(
			value = "SELECT * FROM tasks WHERE tasks.user_id = ?1",
			nativeQuery = true)
	List<Task> findAllTasksById(long id);
	
	@Query(
			value = "SELECT * FROM tasks WHERE (tasks.user_id = ?1 AND tasks.completed = 0)",
			nativeQuery = true)
	List<Task> findAllIncompleteTasksById(long id);

}
