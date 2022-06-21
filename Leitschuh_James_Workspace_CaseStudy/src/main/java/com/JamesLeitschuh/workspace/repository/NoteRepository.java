package com.JamesLeitschuh.workspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JamesLeitschuh.workspace.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
	
	@Query(
			value = "SELECT * FROM notes WHERE notes.user_id = ?1",
			nativeQuery = true)
	List<Note> findAllNotesById(long id);

}
