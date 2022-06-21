package com.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.exception.ResourceNotFoundException;
import com.springboot.web.app.model.Notes;
import com.springboot.web.app.repository.NotesRepository;
import com.springboot.web.app.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService{

	@Autowired
	private NotesRepository notesRepo; 
	
	@Override
	public Notes createNote(Notes note) {
		return notesRepo.save(note);
	}

	@Override
	public List<Notes> getAllNotes() {
		return notesRepo.findAll();
	}
	
	@Override
	public List<Notes> getAllNotesById(long id) {
		return notesRepo.findAllNotesById(id);
	}

	@Override
	public Notes getNoteById(long id) {
		return notesRepo.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public Notes updateNote(Notes note, long id) {
		Notes existingNote = notesRepo.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Note", "Id", id));
		
		existingNote.setNoteName(note.getNoteName());
		existingNote.setNoteContent(note.getNoteContent());
		
		notesRepo.save(existingNote);
		return existingNote;
	}

	@Override
	public void deleteNote(long id) {
		notesRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("User", "Id", id));
		notesRepo.deleteById(id);
		
	}

}
