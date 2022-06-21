package com.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.springboot.web.app.model.Notes;
import com.springboot.web.app.model.Posts;
import com.springboot.web.app.model.User;
import com.springboot.web.app.quotes.Quotes;
import com.springboot.web.app.service.NotesService;
import com.springboot.web.app.service.PostsService;
import com.springboot.web.app.service.UserService;

import org.json.JSONObject;

@Controller
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private PostsService postsService;
	
	// TEST PAGE
	@GetMapping("/user/display")
	public String displayAllUsers(Model model, Authentication authentication) throws JsonMappingException, JsonProcessingException {
		List<User> usersList = userService.getAllUsers();
		model.addAttribute("usersList", usersList);
		
		boolean isTest = true;
		model.addAttribute("isTest", isTest);
		
		Notes note = new Notes();
		model.addAttribute("note", note);
		boolean newNote = true;
		model.addAttribute("newNote", newNote);
		
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		
		
		String uri = "https://api.openweathermap.org/data/2.5/weather?q=plymouth&appid=bf0a61546d9083e91b1a07813951c139&units=imperial";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
//		
//		model.addAttribute("result", result);
		
		// CONVERT RESULT INTO JSON OBJECT
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(result);
		
		ArrayNode testNode = (ArrayNode) node.get("weather");
		
		System.out.println("SIZE OF ARRAY NODE " + testNode.size());
		System.out.println(testNode.get(0).get("description").asText());
		
		System.out.println(node);
		System.out.println(node.get("name").asText());
		System.out.println(node.get("weather").get(0).get("description").asText());
		System.out.println(node.get("main").get("temp").asText());
		
		
		System.out.println(node.get("weather").getClass());
		System.out.println(node.getClass());
		
		
		// Quotes
		
//		Quotes quotes = new Quotes();
//		String quote = quotes.getRandomQuote();	
		
		String quote = "If you’re offered a seat on a rocket ship, don’t ask what seat! Just get on.  Sheryl Sandberg";
		
		
		
		
		model.addAttribute("quote", quote);	
		
		return "test";
	}
	
	@GetMapping("/test")
	public String test(Authentication authentication) {
		// authentication - user session info
		System.out.println(authentication);
		// authentication - gets email (name used for login)
		System.out.println(authentication.getName());
		
		// finds user in system based on email
		System.out.println(userService.findByEmail(authentication.getName()).getId());
		System.out.println(userService.findByEmail(authentication.getName()).getName());
		System.out.println(userService.findByEmail(authentication.getName()).getEmail());
		System.out.println(userService.findByEmail(authentication.getName()).getPassword());
		
		System.out.println(notesService.getAllNotesById(1).get(0).getNoteName());
		
		
		return "redirect:/user/display";
	}

}
