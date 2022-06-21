package com.springboot.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.model.Posts;
import com.springboot.web.app.model.Responses;
import com.springboot.web.app.model.User;
import com.springboot.web.app.service.PostsService;
import com.springboot.web.app.service.ResponsesService;
import com.springboot.web.app.service.UserService;

@Controller
@RequestMapping("responses")
public class ResponsesController {

	@Autowired
	private ResponsesService responsesService;
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/addComment/{id}/{comment}")
	private String addComment(@PathVariable("id") long id,@PathVariable("comment") String comment, Authentication authentication) {
		
		User user = userService.findByEmail(authentication.getName());
		Posts post = postsService.getPostById(id);		
		Responses response = new Responses();
		
		response.setResponseDesc(comment);
		response.setPosts(post);
		response.setUser(user);
		
		responsesService.createResponse(response);
		
		return "redirect:/posts/viewpost/" + id;
	}
	
	@GetMapping("/delete/{id}/{postId}")
	private String deleteComment(@PathVariable("id") long id, @PathVariable("postId") long postId) {
		responsesService.deleteResponse(id);
		return "redirect:/posts/viewpost/" + postId;
	}
}
