package com.springboot.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.web.app.repository.ItemRepo;

@Controller
public class ItemController {
	
	//Constructor Dependency Injection
	
//	private ItemRepo itemRepo;
//	ItemController(ItemRepo itemRepo) {
//		this.itemRepo = itemRepo;
//	}
	
	// Setter Dependency Injection
	
//	private ItemRepo itemRepo;
//	ItemController(ItemRepo itemRepo){
//		this.itemRepo = itemRepo;
//	}
	
	@Autowired
//	@Qualifier("itemRepo")
	private ItemRepo itemRepo;
	
	@GetMapping(path="/")
	public String show() {
		return "Hello To All";
	}
	
	@PostMapping(path = "/add/{id}/{username}")
	public void addEmployee(@PathVariable Long id, @PathVariable String username) {
		itemRepo.save(id,username);
	}
	
	@PostMapping(path = "/edit")
	public void editEmployee() {
		
	}

}
