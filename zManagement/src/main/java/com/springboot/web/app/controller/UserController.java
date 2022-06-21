package com.springboot.web.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot.web.app.model.User;
import com.springboot.web.app.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value="/getall")
	public String getAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("users", new User());
		return "user";
	}
	
//	@GetMapping(value="/getall")
//	public List<User> getAllUsers(Model model) {
//		List<User> users = userService.getAllUsers();
//		return users;
//	}
	
	@PostMapping(value="/adduser")
	public String addUser(Model model, @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "userEntity";
		}
		
		userService.addUser(user);
		
		return "redirect:/";
	}
	
	@GetMapping(path="/{id}")
	public String getUser(@PathVariable("id") long id, Model model) {
		Optional<User> userInfo = userService.getUsernameById(id);
		model.addAttribute("userInfo", userInfo);
		return "edit";
	}
	
	@PostMapping(path="/{id}")
	public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id, @ModelAttribute User userInfo) {
		userService.updateUser(id, userInfo);
		String message = (userInfo.isActive() ? "Update" : "Delete") + "<b>" + userInfo.getUserName() + "</b>**";
		RedirectView redirectView = new RedirectView("/", true);
		redirectAttributes.addFlashAttribute("userMessage", message);
		return redirectView;
	}
}
