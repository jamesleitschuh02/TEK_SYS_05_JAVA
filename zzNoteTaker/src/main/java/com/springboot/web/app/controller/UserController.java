package com.springboot.web.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.dto.UserRegistrationDto;
import com.springboot.web.app.model.Notes;
import com.springboot.web.app.model.User;
import com.springboot.web.app.service.NotesService;
import com.springboot.web.app.service.UserService;

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
		
		return "new-updateUser";
	}
	
	@PostMapping("/create")
	public String registerUserAccount(@ModelAttribute("user")@Valid UserRegistrationDto userDto, BindingResult result){
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
		
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		userService.createUser(newUser);
		
		return "redirect:/main/settings/";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Authentication authentication) {
		
		long id = userService.findByEmail(authentication.getName()).getId();
		
//		System.out.println(userService.findByEmail(authentication.getName()));
		
		userService.deleteUser(id);
		return "redirect:/main/login/";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	// create user
//	@PostMapping("/create")
//	public ResponseEntity<User> createUser(@RequestBody User user){
//		return new ResponseEntity<User>(
//				userService.createUser(user),
//				HttpStatus.CREATED);
//	}
//	
//	//	 get all users
//	@GetMapping("/getall")
//	public List<User> getAllUsers(){
//		return userService.getAllUsers();
//		
//	}
//	
//
//
//	// get user by ID
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
//		return new ResponseEntity<User>(
//				userService.getUserById(userId),
//				HttpStatus.OK);
//	}
//	
//	// update user
//	@PutMapping("{id}")
//	public ResponseEntity<User> updateUser(
//			@PathVariable("id") long userId, @RequestBody User user) {
//		return new ResponseEntity<User>(
//				userService.updateUser(user, userId),
//				HttpStatus.OK);
//	}
//	
//	// delete user
//	@DeleteMapping("{id}")
//	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
//		userService.deleteUser(id);
//		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
//	}

}
