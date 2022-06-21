package com.springboot.web.app.controller;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.springboot.web.app.model.Notes;
import com.springboot.web.app.model.Posts;
import com.springboot.web.app.model.Task;
import com.springboot.web.app.model.Upcomming;
import com.springboot.web.app.model.User;
import com.springboot.web.app.quotes.Quotes;
import com.springboot.web.app.service.NotesService;
import com.springboot.web.app.service.PostsService;
import com.springboot.web.app.service.TaskService;
import com.springboot.web.app.service.UpcommingService;
import com.springboot.web.app.service.UserService;

//"https://api.openweathermap.org/data/2.5/weather?q=plymouth&appid=bf0a61546d9083e91b1a07813951c139&units=imperial"

@Controller
@RequestMapping("/main")
public class NavigationController {
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UpcommingService upcommingService;
	
	@Autowired
	private PostsService postsService;
	
	@GetMapping("/")
	public String getMainPage(Model model, Authentication authentication) throws JsonMappingException, JsonProcessingException {
		
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		
		List<Notes> notesList = notesService.getAllNotes();
		List<Task> taskList = taskService.getAllTasks();
		List<Upcomming> upcommingList = upcommingService.getAllEvents();
		model.addAttribute("notesList", notesList);
		model.addAttribute("taskList", taskList);
		model.addAttribute("eventList", upcommingList);
		
		LocalDate date = LocalDate.now();
		DayOfWeek day = date.getDayOfWeek();
		model.addAttribute("day", day);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
		String today = dtf.format(LocalDate.now());
		model.addAttribute("today", today);
		
		String uri = "https://api.openweathermap.org/data/2.5/weather?q=plymouth&appid=bf0a61546d9083e91b1a07813951c139&units=imperial";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		
		// CONVERT RESULT INTO JSON OBJECT
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(result);
		
		String cityName = node.get("name").asText();
		String cityDescription = node.get("weather").get(0).get("description").asText();
		String cityTemp = node.get("main").get("temp").asText();
		
		model.addAttribute("cityName", cityName);
		model.addAttribute("cityDescription", cityDescription);
		model.addAttribute("cityTemp", cityTemp);
		
		// GET QUOTE
		Quotes quotes = new Quotes();
		String[] quote = quotes.getRandomQuote();	
		model.addAttribute("quote", quote[0]);
		model.addAttribute("author", quote[1]);
		
		
		return ("main");
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/notes")
	public String getNotesPage(Model model, Authentication authentication) {
		
		long id = userService.findByEmail(authentication.getName()).getId();

		List<Notes> notesList = notesService.getAllNotesById(id);
		
		model.addAttribute("notesList", notesList);
		return "notesPage";
	}
	
	@GetMapping("/settings")
	public String getSettingsPage(Model model, Authentication authentication) {	
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		return "settings";
	}
	
	@GetMapping("/task")
	public String getTaskPage(Model model, Authentication authentication) {
		
		long id = userService.findByEmail(authentication.getName()).getId();
		
		List<Task> taskList = taskService.getAllTasksById(id);

		model.addAttribute("taskList", taskList);
		return "todoPage";
	}
	
	@GetMapping("/upcomming")
	public String getUpcommingPage(Model model, Authentication authentication) {
		
		long id = userService.findByEmail(authentication.getName()).getId();
		
		List<Upcomming> upcommingList = upcommingService.getAllEventsById(id);
		
		model.addAttribute("eventList", upcommingList);
		return "upcommingPage";
	}
	
	@GetMapping("/posts")
	public String getPostsPage(Model model, Authentication authentication) {
		
		long id = userService.findByEmail(authentication.getName()).getId();
		
		List<Posts> postList = postsService.getAllPosts();
		
		model.addAttribute("postList", postList);
		model.addAttribute("id", id);
		
		return "postsPage";
	}

}
