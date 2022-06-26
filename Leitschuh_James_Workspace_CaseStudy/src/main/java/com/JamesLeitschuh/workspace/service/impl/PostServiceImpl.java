package com.JamesLeitschuh.workspace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JamesLeitschuh.workspace.exception.ResourceNotFoundException;
import com.JamesLeitschuh.workspace.model.Post;
import com.JamesLeitschuh.workspace.repository.PostRepository;
import com.JamesLeitschuh.workspace.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public Post createPost(Post post) {
		return postRepo.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}
	
	@Override
	public List<Post> getAllPostsOrderedByUser() {
		return postRepo.findAllPostsOrderedByUser();
	}

	@Override
	public Post getPostById(long id) {
		return postRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public void deletePost(long id) {
		postRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Note", "id", id));
		postRepo.deleteById(id);		
	}

}
