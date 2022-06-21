package com.JamesLeitschuh.workspace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JamesLeitschuh.workspace.dto.UserRegistrationDto;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String newUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		boolean newUser = true;
		model.addAttribute("newUser", newUser);
		
		return "new-user";
	}
	
	@PostMapping("/create")
	public String registerUserAccount(@ModelAttribute("user")@Valid UserRegistrationDto userDto, BindingResult result){
		System.out.println("user Dto first name:" + userDto.getFirstName());
		System.out.println("user Dto last name:" + userDto.getLastName());
		userService.save(userDto);
		return "redirect:/main/login/";
	}
		   
	@GetMapping("/updateUserPage/{id}")
	public String updateUserPage(Model model, @PathVariable("id") long id) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);	
		
		boolean newUser = false;
		model.addAttribute("newUser", newUser);
		
		return "new-updateUser";
	}
	
	@PostMapping("/saveUserUpdates")
	public String saveUserUpdates(@ModelAttribute("user") User user) {	
		User newUser = userService.getUserById(user.getId());
		
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		userService.createUser(newUser);
		
		return "redirect:/main/settings/";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Authentication authentication) {	
		long id = userService.findByEmail(authentication.getName()).getId();
		
		userService.deleteUser(id);
		return "redirect:/main/login/";
	}

}
