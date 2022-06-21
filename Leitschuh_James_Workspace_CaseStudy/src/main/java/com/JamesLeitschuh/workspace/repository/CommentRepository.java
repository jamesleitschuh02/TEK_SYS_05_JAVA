package com.JamesLeitschuh.workspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JamesLeitschuh.workspace.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	@Query(
			value = "SELECT * FROM comments WHERE comments.posts_id = ?1",
			nativeQuery = true)
	List<Comment> findAllCommentsById(long id);
	

}
