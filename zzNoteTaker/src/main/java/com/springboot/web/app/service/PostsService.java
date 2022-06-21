package com.springboot.web.app.service;

import java.util.List;

import com.springboot.web.app.model.Posts;

public interface PostsService {

	Posts createPost(Posts post);
	
	List<Posts> getAllPosts();
	
	Posts getPostById(long id);
	
	void deletePost(long id);
}
