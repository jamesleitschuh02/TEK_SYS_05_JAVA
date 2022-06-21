package com.JamesLeitschuh.workspace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JamesLeitschuh.workspace.exception.ResourceNotFoundException;
import com.JamesLeitschuh.workspace.model.Note;
import com.JamesLeitschuh.workspace.repository.NoteRepository;
import com.JamesLeitschuh.workspace.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepo;

	@Override
	public Note createNote(Note note) {
		return noteRepo.save(note);
	}

	@Override
	public List<Note> getAllNotes() {
		return noteRepo.findAll();
	}

	@Override
	public List<Note> getAllNotesById(long id) {
		return noteRepo.findAllNotesById(id);
	}

	@Override
	public Note getNoteById(long id) {
		return noteRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public Note updateNote(Note note, long id) {
		Note existingNote = noteRepo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Note", "Id", id));

		existingNote.setNoteName(note.getNoteName());
		existingNote.setNoteContent(note.getNoteContent());

		noteRepo.save(existingNote);
		return existingNote;
	}

	@Override
	public void deleteNote(long id) {
		noteRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", id));
		noteRepo.deleteById(id);		
	}

}
