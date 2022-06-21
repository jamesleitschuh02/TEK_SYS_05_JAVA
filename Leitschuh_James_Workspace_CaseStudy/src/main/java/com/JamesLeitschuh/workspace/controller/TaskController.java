package com.JamesLeitschuh.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JamesLeitschuh.workspace.model.Task;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.service.TaskService;
import com.JamesLeitschuh.workspace.service.UserService;

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
		
		return "new-update-task";
	}
	
	@PostMapping("/create")
	public String createTask(@ModelAttribute("task") Task task, Authentication authentication) {
		task.setCompleted(false);
		
		User user = userService.findByEmail(authentication.getName());
		task.setUser(user);
		
		taskService.createTask(task);
		return "redirect:/main/task";
	}
	
	@GetMapping("/update/{id}")
	public String updateTask(Model model, @PathVariable("id")long taskId) {
		Task task = taskService.getTaskById(taskId);
		model.addAttribute("task", task);
		
		boolean newTask = false;
		model.addAttribute("newTask", newTask);
		
		return "new-update-task";
	}
	
	@PostMapping("/saveUpdates")
	public String saveTaskUpdates(@ModelAttribute("task") Task task) {
		Task newTask = taskService.getTaskById(task.getTaskId());
		newTask.setTaskName(task.getTaskName());
		taskService.createTask(newTask);
		return "redirect:/main/task";
	}
	
	@GetMapping("/changeComplete/{id}")
	public String changeCompleteTask(@PathVariable("id") long taskId) {
		Task newTask = taskService.getTaskById(taskId);
		newTask.setCompleted(!newTask.isCompleted());
		taskService.createTask(newTask);
		return "redirect:/main/task";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") long taskId) {
		taskService.deleteTask(taskId);
		return "redirect:/main/task";
	}

}
