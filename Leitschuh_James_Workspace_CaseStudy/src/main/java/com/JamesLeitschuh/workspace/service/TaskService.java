package com.JamesLeitschuh.workspace.service;

import java.util.List;

import com.JamesLeitschuh.workspace.model.Task;

public interface TaskService {

	Task createTask(Task task);
	
	List<Task> getAllTasks();
	
	List<Task> getAllTasksById(long id);
	
	Task getTaskById(long id);
	
	Task updateTask(Task task, long id);
	
	void deleteTask(long id);
}
