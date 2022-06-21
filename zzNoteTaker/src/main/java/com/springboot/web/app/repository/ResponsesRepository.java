package com.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.web.app.model.Responses;

public interface ResponsesRepository extends JpaRepository<Responses, Long> {
	
	@Query(
			value = "SELECT * FROM responses WHERE responses.posts_id = ?1",
			nativeQuery = true)
	List<Responses> findAllResponsesById(long id);
	

}
