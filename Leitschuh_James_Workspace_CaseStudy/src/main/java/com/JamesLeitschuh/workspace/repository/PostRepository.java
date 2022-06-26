package com.JamesLeitschuh.workspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JamesLeitschuh.workspace.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	@Query(
			value = "SELECT * FROM posts ORDER BY user_id",
			nativeQuery = true)
	List<Post> findAllPostsOrderedByUser();

}
