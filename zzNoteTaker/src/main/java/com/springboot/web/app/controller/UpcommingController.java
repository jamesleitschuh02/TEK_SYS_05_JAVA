package com.springboot.web.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.model.Upcomming;
import com.springboot.web.app.model.User;
import com.springboot.web.app.service.UpcommingService;
import com.springboot.web.app.service.UserService;

@Controller
@RequestMapping("/upcomming")
public class UpcommingController {
	
	@Autowired
	private UpcommingService upcommingService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	private String getNewUpcommingPage(Model model) {
		Upcomming upcomming = new Upcomming();
		
		boolean newEvent = true;
		model.addAttribute("newEvent", newEvent);
		
		model.addAttribute("upcomming", upcomming);
		return "new-updateUpcomming";
	}
	
	@PostMapping("/create")
	private String saveUpcomming(@ModelAttribute("upcomming") Upcomming upcomming, Authentication authentication) {		
		User user = userService.findByEmail(authentication.getName());
		upcomming.setUser(user);
		
		upcommingService.createEvent(upcomming);
		return "redirect:/main/upcomming/";
	}
	
	@GetMapping("/update/{id}")
	private String updateUpcomming(Model model, @PathVariable("id") long upcommingId) {
		Upcomming upcomming = upcommingService.getEventById(upcommingId);
		model.addAttribute("upcomming", upcomming);
		
		boolean newEvent = false;
		model.addAttribute("newEvent", newEvent);
		
		return "new-updateUpcomming";
	}
	
	@PostMapping("/saveUpdates")
	private String saveUpdates(@ModelAttribute("upcomming") Upcomming upcomming) {
		Upcomming newUpcomming = upcommingService.getEventById(upcomming.getUpcommingId());
		newUpcomming.setEventName(upcomming.getEventName());
		newUpcomming.setEventDate(upcomming.getEventDate());
		upcommingService.createEvent(newUpcomming);
		return "redirect:/main/upcomming";
	}
	
	@GetMapping("/delete/{id}")
	private String deleteUpcomming(@PathVariable("id") long upcommingId) {
		upcommingService.deleteEvent(upcommingId);
		return "redirect:/main/upcomming";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// create Upcomming Event
//	@PostMapping("/create")
//	public ResponseEntity<Upcomming> createEvent(@RequestBody Upcomming event){
//		return new ResponseEntity<Upcomming>(
//				upcommingService.createEvent(event),
//				HttpStatus.CREATED);
//	}
//		
//	// get all Upcomming Events
//	@GetMapping("/getall")
//	public List<Upcomming> getAllEvents(){
//		return upcommingService.getAllEvents();
//			
//	}
//
//
//	// get Upcomming Event by ID
//	@GetMapping("/{id}")
//	public ResponseEntity<Upcomming> getEventById(@PathVariable("id") long eventId) {
//		return new ResponseEntity<Upcomming>(
//				upcommingService.getEventById(eventId),
//				HttpStatus.OK);
//	}
//		
//	// update Upcomming Event
//	@PutMapping("{id}")
//	public ResponseEntity<Upcomming> updateEvent(
//			@PathVariable("id") long eventId, @RequestBody Upcomming event) {
//		return new ResponseEntity<Upcomming>(
//				upcommingService.updateEvent(event, eventId),
//				HttpStatus.OK);
//	}
//		
//	// delete Upcomming Event
//	@DeleteMapping("{id}")
//	public ResponseEntity<String> deleteEvent(@PathVariable("id") long id) {
//		upcommingService.deleteEvent(id);
//		return new ResponseEntity<String>("Event deleted", HttpStatus.OK);
//	}


}
