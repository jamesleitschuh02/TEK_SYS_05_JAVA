package com.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.web.app.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{
	
	@Query(
	value = "SELECT * FROM notes WHERE notes.user_id = ?1", 
	nativeQuery = true)
	List<Notes> findAllNotesById(long id);

}
