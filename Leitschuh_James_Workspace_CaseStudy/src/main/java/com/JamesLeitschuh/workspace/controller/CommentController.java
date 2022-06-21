package com.JamesLeitschuh.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JamesLeitschuh.workspace.model.Comment;
import com.JamesLeitschuh.workspace.model.Post;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.service.CommentService;
import com.JamesLeitschuh.workspace.service.PostService;
import com.JamesLeitschuh.workspace.service.UserService;


@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/addComment/{id}/{comment}")
	private String addComment(@PathVariable("id") long id,
							  @PathVariable("comment") String comment, 
							  Authentication authentication) {
		
		User user = userService.findByEmail(authentication.getName());
		Post post = postService.getPostById(id);		
		Comment newComment = new Comment();
		
		newComment.setCommentDesc(comment);
		newComment.setPosts(post);
		newComment.setUser(user);
		
		commentService.createComment(newComment);
		
		return "redirect:/posts/viewpost/" + id;
	}
	
	@GetMapping("/delete/{id}/{postId}")
	private String deleteComment(@PathVariable("id") long id,
								 @PathVariable("postId") long postId) {
		
		commentService.deleteComment(id);
		return "redirect:/posts/viewpost/" + postId;
	}

}
