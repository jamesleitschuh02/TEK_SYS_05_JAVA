package com.example.myspringdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myspringdata.entity.UserEntity;
import com.example.myspringdata.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(path="/user")    // path is your website URL localhost:8080/example
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired // a constructor injection
	private UserRepository userRepo;
	
	@PostMapping(path="/add") // when we make a request, we need a handler
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {   // response is a JSON file
		UserEntity newUser = new UserEntity();
		newUser.setName(name);
		newUser.setEmail(email);
		// gives us an updated object, to have a new name & email
		userRepo.save(newUser);
		
		logger.warn("Warning from post email: " + email);
		logger.info("Info from post " + name);
		logger.debug("from post controller");
		
		return "Saved new user";
	}
	
	@GetMapping(path="/getAll")
	public @ResponseBody Iterable<UserEntity> getAllUsers(){
		logger.info("getall method");
	    return userRepo.findAll(); // 	
	}
	
	@DeleteMapping(path="/delete/")
	public @ResponseBody String deleteUser(@RequestParam int id) {
		userRepo.deleteById(id);
		return "Deleted user.";
	}
}
