package com.example.myspringdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class WebController {

	
	@GetMapping() 
    public String greeting() {
         return "hello"; 
         // returns the already proccessed model from src/main/resources/templates/greeting.html 
    }
}
