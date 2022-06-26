package com.JamesLeitschuh.workspace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
	
	@GetMapping("/update/firstName")
	public String updateFirstName(Model model, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		return "update-user-first-name";
	}
	
	@PostMapping("/update/firstName")
	public String updateFirstName(@ModelAttribute("user") User user, Authentication authentication) {
		User existingUser = userService.findByEmail(authentication.getName());
		existingUser.setFirstName(user.getFirstName());
		userService.createUser(existingUser);
		return "redirect:/main/settings";
	}
	
	@GetMapping("/update/lastName")
	public String updateLastName(Model model, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		return "update-user-last-name";
	}
	
	@PostMapping("/update/lastName")
	public String updateLastName(@ModelAttribute("user") User user, Authentication authentication) {
		User existingUser = userService.findByEmail(authentication.getName());
		existingUser.setLastName(user.getLastName());
		userService.createUser(existingUser);
		return "redirect:/main/settings";
	}
	
	@GetMapping("/update/email")
	public String updateEmail(Model model, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		return "update-user-email";
	}
	
	@PostMapping("/update/email")
	public String updateEmail(@ModelAttribute("user") User user, Authentication authentication) {
		User existingUser = userService.findByEmail(authentication.getName());
		existingUser.setEmail(user.getEmail());
		userService.createUser(existingUser);
		return "redirect:/logout";
	}
	
	@GetMapping("/update/city")
	public String updateCity(Model model, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		return "update-user-city";
	}
	
	@PostMapping("/update/city")
	public String updateCity(@ModelAttribute("user") User user, Authentication authentication) {
		User existingUser = userService.findByEmail(authentication.getName());
		existingUser.setCity(user.getCity());
		userService.createUser(existingUser);
		return "redirect:/main/settings";
	}
	
	@GetMapping("/update/password")
	public String updatePassword(Model model, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		return "update-user-password";
	}
	
	@PostMapping("/update/password")
	public String updatePassword(@ModelAttribute("user") User user, Authentication authentication) {
		User existingUser = userService.findByEmail(authentication.getName());
		existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.createUser(existingUser);
		return "redirect:/main/settings";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Authentication authentication) {	
		long id = userService.findByEmail(authentication.getName()).getId();
		
		userService.deleteUser(id);
		return "redirect:/main/login/";
	}

}
