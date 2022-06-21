package com.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.exception.ResourceNotFoundException;
import com.springboot.web.app.model.Posts;
import com.springboot.web.app.repository.PostsRepository;
import com.springboot.web.app.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService {
	
	@Autowired
	private PostsRepository postsRepo;

	@Override
	public Posts createPost(Posts post) {
		return postsRepo.save(post);
	}

	@Override
	public List<Posts> getAllPosts() {
		return postsRepo.findAll();
	}

	@Override
	public Posts getPostById(long id) {
		return postsRepo.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public void deletePost(long id) {
		postsRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Note", "id", id));
		postsRepo.deleteById(id);		
	}

}
