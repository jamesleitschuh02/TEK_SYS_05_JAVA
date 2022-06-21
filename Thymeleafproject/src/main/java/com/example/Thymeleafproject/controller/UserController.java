package com.example.Thymeleafproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Thymeleafproject.entity.UserEntity;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
    //making a request, then using a method to handle that request
    @GetMapping(value="/")
    public String index(){ // handle method
        return "index"; // return a html doc to the screen
    }
    @PostMapping(value="/profile")
//    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ModelAndView profile(@ModelAttribute UserEntity userEntity) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("profile"); // view it on our profile page
    	modelAndView.addObject("UserEntity", userEntity); // access to data from user entity
    	return modelAndView;
    }


}
