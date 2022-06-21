package com.JamesLeitschuh.workspace.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.JamesLeitschuh.workspace.model.Event;
import com.JamesLeitschuh.workspace.model.Note;
import com.JamesLeitschuh.workspace.model.Post;
import com.JamesLeitschuh.workspace.model.Task;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.quotes.Quotes;
import com.JamesLeitschuh.workspace.service.EventService;
import com.JamesLeitschuh.workspace.service.NoteService;
import com.JamesLeitschuh.workspace.service.PostService;
import com.JamesLeitschuh.workspace.service.TaskService;
import com.JamesLeitschuh.workspace.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String getMainPage(Model model, Authentication authentication) throws JsonMappingException, JsonProcessingException {
		
		User user = userService.findByEmail(authentication.getName());
		model.addAttribute("user", user);
		
		List<Note> notesList = noteService.getAllNotes();
		List<Task> taskList = taskService.getAllTasks();
		List<Event> eventList = eventService.getAllEvents();
		model.addAttribute("notesList", notesList);
		model.addAttribute("taskList", taskList);
		model.addAttribute("eventList", eventList);
		
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

		List<Note> notesList = noteService.getAllNotesById(id);
		
		model.addAttribute("notesList", notesList);
		return "notes";
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
		return "task";
	}
	
	@GetMapping("/event")
	public String getUpcommingPage(Model model, Authentication authentication) {
		
		long id = userService.findByEmail(authentication.getName()).getId();
		
		List<Event> eventList = eventService.getAllEventsByIdOrdered(id);
		
		model.addAttribute("eventList", eventList);
		return "event";
	}
	
	@GetMapping("/posts")
	public String getPostsPage(Model model, Authentication authentication) {
		
		long id = userService.findByEmail(authentication.getName()).getId();
		
		List<Post> postList = postService.getAllPosts();
		
		model.addAttribute("postList", postList);
		model.addAttribute("id", id);
		
		return "posts";
	}

}
