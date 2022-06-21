package com.springboot.web.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.web.app.entity.UserEntity;
import com.springboot.web.app.repository.UserRepository;

@Controller
@RequestMapping(path="/example")
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser(
			@RequestParam String name, 
			@RequestParam String email) {
		UserEntity newUser = new UserEntity();
		newUser.setName(name);
		newUser.setEmail(email);
		userRepo.save(newUser);
		
		return "Saved new user";
	}
	
	@GetMapping(path="/getall")
	public @ResponseBody Iterable<UserEntity> getAllUsers(){
		logger.info("Just found all");
		return userRepo.findAll();
	}

	
}
