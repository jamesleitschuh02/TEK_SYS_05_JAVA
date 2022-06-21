package com.springboot.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.model.Task;
import com.springboot.web.app.model.User;
import com.springboot.web.app.service.TaskService;
import com.springboot.web.app.service.UserService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService; 
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/create")
	public String getNewTaskPage(Model model) {
		Task task = new Task();
		model.addAttribute("task", task);
		
		boolean newTask = true;
		model.addAttribute("newTask", newTask);
		
		return "new-updateTodo";
	}
	
	@PostMapping("/create")
	public String createTask(@ModelAttribute("task") Task task, Authentication authentication) {
		task.setCompleted(false);
		
		User user = userService.findByEmail(authentication.getName());
		task.setUser(user);
		
		taskService.createTask(task);
		return "redirect:/main/task/";
	}
	
	@GetMapping("/update/{id}")
	public String updateTask(Model model, @PathVariable("id")long taskId) {
		Task task = taskService.getTaskById(taskId);
		model.addAttribute("task", task);
		
		boolean newTask = false;
		model.addAttribute("newTask", newTask);
		
		return "new-updateTodo";
	}
	
	@PostMapping("/saveUpdates")
	public String saveTaskUpdates(@ModelAttribute("task") Task task) {
		Task newTask = taskService.getTaskById(task.getTaskId());
		newTask.setTaskName(task.getTaskName());
		taskService.createTask(newTask);
		return "redirect:/main/task/";
	}
	
	@GetMapping("/changeComplete/{id}")
	public String changeCompleteTask(@PathVariable("id") long taskId) {
		Task newTask = taskService.getTaskById(taskId);
		newTask.setCompleted(!newTask.isCompleted());
		taskService.createTask(newTask);
		return "redirect:/main/task/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") long taskId) {
		taskService.deleteTask(taskId);
		return "redirect:/main/task/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// create Task
//	@PostMapping("/create")
//	public ResponseEntity<Task> createTask(@RequestBody Task task){
//		return new ResponseEntity<Task>(
//				taskService.createTask(task),
//				HttpStatus.CREATED);
//	}
//			
//	// get all Task
//	@GetMapping("/getall")
//	public List<Task> getAllTasks(){
//		return taskService.getAllTasks();
//				
//	}
//
//
//	// get Task by ID
//	@GetMapping("/{id}")
//	public ResponseEntity<Task> getTaskById(@PathVariable("id") long taskId) {
//		return new ResponseEntity<Task>(
//				taskService.getTaskById(taskId),
//				HttpStatus.OK);
//	}
//			
//	// update Note
//	@PutMapping("{id}")
//	public ResponseEntity<Task> updateTask(
//			@PathVariable("id") long taskId, @RequestBody Task task) {
//		return new ResponseEntity<Task>(
//				taskService.updateTask(task, taskId),
//				HttpStatus.OK);
//	}
//			
//	// delete Note
//	@DeleteMapping("{id}")
//	public ResponseEntity<String> deleteTask(@PathVariable("id") long id) {
//		taskService.deleteTask(id);
//		return new ResponseEntity<String>("Task Deleted", HttpStatus.OK);
//	}

}
