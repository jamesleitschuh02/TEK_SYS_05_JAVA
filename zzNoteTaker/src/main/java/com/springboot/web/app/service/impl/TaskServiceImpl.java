package com.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.exception.ResourceNotFoundException;
import com.springboot.web.app.model.Notes;
import com.springboot.web.app.model.Task;
import com.springboot.web.app.repository.TaskRepository;
import com.springboot.web.app.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}
	
	@Override
	public List<Task> getAllTasksById(long id) {
		return taskRepo.findAllTasksById(id);
	}

	@Override
	public Task getTaskById(long id) {
		return taskRepo.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Task", "id", id));
	}

	@Override
	public Task updateTask(Task task, long id) {
		Task existingTask = taskRepo.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Task", "Id", id));
		
		existingTask.setTaskName(task.getTaskName());
		existingTask.setCompleted(task.isCompleted());
		
		taskRepo.save(existingTask);
		return existingTask;
	}

	@Override
	public void deleteTask(long id) {
		taskRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("User", "Id", id));
		taskRepo.deleteById(id);
		
	}

}
