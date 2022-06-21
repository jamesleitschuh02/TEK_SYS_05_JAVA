package com.JamesLeitschuh.workspace.service;

import java.util.List;

import com.JamesLeitschuh.workspace.model.Comment;

public interface CommentService {
	
	Comment createComment(Comment comment);
	
	List<Comment> getAllComments();
	
	List<Comment> getAllCommentsById(long id);
	
	void deleteComment(long id);

}
