package com.JamesLeitschuh.workspace.controller;

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

import com.JamesLeitschuh.workspace.model.Comment;
import com.JamesLeitschuh.workspace.model.Post;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.service.CommentService;
import com.JamesLeitschuh.workspace.service.PostService;
import com.JamesLeitschuh.workspace.service.UserService;

@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String addPost(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "new-post";
	}
	
	@PostMapping("/create")
	public String savePost(@ModelAttribute("post") Post post, Authentication authentication) {
		User user = userService.findByEmail(authentication.getName());
		post.setUser(user);
		postService.createPost(post);
		return "redirect:/main/posts";
	}
	
	@GetMapping("/viewpost/{id}")
	public String viewPost(@PathVariable("id") long id, Model model, Authentication authentication) {
		Post post = postService.getPostById(id);
		model.addAttribute("post", post);
		
		long userId = userService.findByEmail(authentication.getName()).getId();
		model.addAttribute("id", userId);
		
		List<Comment> commentList = commentService.getAllCommentsById(id);
		model.addAttribute("responseList", commentList);
		
		
		return "viewPostPage";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePost(@PathVariable("id") long id) {
		postService.deletePost(id);
		return "redirect:/main/posts";
	}

}
