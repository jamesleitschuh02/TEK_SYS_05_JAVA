package com.springboot.web.app.controller;

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

import com.springboot.web.app.model.Posts;
import com.springboot.web.app.model.Responses;
import com.springboot.web.app.model.User;
import com.springboot.web.app.service.PostsService;
import com.springboot.web.app.service.ResponsesService;
import com.springboot.web.app.service.UserService;

@Controller
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private ResponsesService responsesService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String addPost(Model model) {
		Posts post = new Posts();
		model.addAttribute("post", post);
		return "new-post";
	}
	
	@PostMapping("/create")
	public String savePost(@ModelAttribute("post") Posts post, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		post.setUser(user);
		postsService.createPost(post);
		return "redirect:/main/posts";
	}
	
	@GetMapping("/viewpost/{id}")
	public String viewPost(@PathVariable("id") long id, Model model, Authentication authentication) {
		Posts post = postsService.getPostById(id);
		model.addAttribute("post", post);
		
		long userId = userService.findByEmail(authentication.getName()).getId();
		model.addAttribute("id", userId);
		
		List<Responses> responseList = responsesService.getAllResponsesById(id);
		model.addAttribute("responseList", responseList);
		
		
		return "viewPostPage";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePost(@PathVariable("id") long id) {
		postsService.deletePost(id);
		return "redirect:/main/posts";
	}

}
