package com.JamesLeitschuh.workspace.service;

import java.util.List;

import com.JamesLeitschuh.workspace.model.Post;

public interface PostService {

	Post createPost(Post post);
	
	List<Post> getAllPosts();
	
	List<Post> getAllPostsOrderedByUser();
	
	Post getPostById(long id);
	
	void deletePost(long id);
}
