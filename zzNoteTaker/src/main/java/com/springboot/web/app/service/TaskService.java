package com.springboot.web.app.service;

import java.util.List;

import com.springboot.web.app.model.Task;

public interface TaskService {
	
	Task createTask(Task task);
	
	List<Task> getAllTasks();
	
	List<Task> getAllTasksById(long id);
	
	Task getTaskById(long id);
	
	Task updateTask(Task task, long id);
	
	void deleteTask(long id);

}
