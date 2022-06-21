package com.JamesLeitschuh.workspace.service;

import java.util.List;

import com.JamesLeitschuh.workspace.model.Note;

public interface NoteService {
	
	Note createNote(Note note);
	
	List<Note> getAllNotes();
	
	List<Note> getAllNotesById(long id);
	
	Note getNoteById(long id);
	
	Note updateNote(Note note, long id);
	
	void deleteNote(long id);

}
