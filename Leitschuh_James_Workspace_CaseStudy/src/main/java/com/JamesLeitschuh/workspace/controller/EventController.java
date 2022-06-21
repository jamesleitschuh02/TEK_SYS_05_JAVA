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

import com.JamesLeitschuh.workspace.model.Event;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.service.EventService;
import com.JamesLeitschuh.workspace.service.UserService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	private String getNewEventPage(Model model) {
		Event event = new Event();
		
		boolean newEvent = true;
		model.addAttribute("newEvent", newEvent);
		
		model.addAttribute("event", event);
		return "new-update-event";
	}
	
	@PostMapping("/create")
	private String saveEvent(@ModelAttribute("upcomming") Event event, Authentication authentication) {		
		User user = userService.findByEmail(authentication.getName());
		event.setUser(user);
		
		eventService.createEvent(event);
		return "redirect:/main/event";
	}
	
	@GetMapping("/update/{id}")
	private String updateEvent(Model model, @PathVariable("id") long eventId) {
		Event event = eventService.getEventById(eventId);
		model.addAttribute("upcomming", event);
		
		boolean newEvent = false;
		model.addAttribute("newEvent", newEvent);
		
		return "new-update-event";
	}
	
	@PostMapping("/saveUpdates")
	private String saveUpdates(@ModelAttribute("upcomming") Event event) {
		Event newEvent = eventService.getEventById(event.getEventId());
		newEvent.setEventName(event.getEventName());
		newEvent.setEventDate(event.getEventDate());
		eventService.createEvent(newEvent);
		return "redirect:/main/event";
	}
	
	@GetMapping("/delete/{id}")
	private String deleteEvent(@PathVariable("id") long eventId) {
		eventService.deleteEvent(eventId);
		return "redirect:/main/event";
	}

}
