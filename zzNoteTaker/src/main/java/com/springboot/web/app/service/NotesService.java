package com.springboot.web.app.service;

import java.util.List;

import com.springboot.web.app.model.Notes;
import com.springboot.web.app.model.User;

public interface NotesService {
	
	Notes createNote(Notes note);
	
	List<Notes> getAllNotes();
	
	List<Notes> getAllNotesById(long id);
	
	Notes getNoteById(long id);
	
	Notes updateNote(Notes note, long id);
	
	void deleteNote(long id);

}
