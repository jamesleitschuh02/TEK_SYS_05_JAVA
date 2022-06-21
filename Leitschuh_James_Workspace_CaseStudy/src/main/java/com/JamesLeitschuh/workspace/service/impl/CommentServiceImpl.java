package com.JamesLeitschuh.workspace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JamesLeitschuh.workspace.exception.ResourceNotFoundException;
import com.JamesLeitschuh.workspace.model.Comment;
import com.JamesLeitschuh.workspace.repository.CommentRepository;
import com.JamesLeitschuh.workspace.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;

	@Override
	public Comment createComment(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		return commentRepo.findAll();
	}

	@Override
	public List<Comment> getAllCommentsById(long id) {
		return commentRepo.findAllCommentsById(id);
	}

	@Override
	public void deleteComment(long id) {
		commentRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", id));
	commentRepo.deleteById(id);
		
	}

}
