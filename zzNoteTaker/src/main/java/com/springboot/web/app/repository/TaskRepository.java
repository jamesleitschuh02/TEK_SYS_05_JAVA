package com.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.web.app.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query(
	value = "SELECT * FROM task WHERE task.user_id = ?1", 
	nativeQuery = true)
	List<Task> findAllTasksById(long id);

}
