package com.JamesLeitschuh.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JamesLeitschuh.workspace.model.Note;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.service.NoteService;
import com.JamesLeitschuh.workspace.service.UserService;

@Controller
@RequestMapping("/notes")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String getNewNotePage(Model model) {
		Note note = new Note();
		model.addAttribute("note", note);
		
		boolean newNote = true;
		model.addAttribute("newNote", newNote);
		
		return "new-note";
	}

	@PostMapping("/create")
	public String saveNote(@ModelAttribute("note") Note note, Authentication authentication) {
		
		User user = userService.findByEmail(authentication.getName());
		note.setUser(user);
		
		noteService.createNote(note);
		return "redirect:/main/notes/";
	}
	
	@GetMapping("/update/{id}/{title}/{content}")
	public String updateNote(@PathVariable("id") long id, 
							 @PathVariable("title") String title, 
							 @PathVariable("content") String content) {
		Note newNote = noteService.getNoteById(id);
		newNote.setNoteName(title);
		newNote.setNoteContent(content);
		noteService.createNote(newNote);
		return "redirect:/main/notes";
	}
	
	@PostMapping("/saveUpdates")
	public String saveNoteUpdates(@ModelAttribute("note") Note note) {
		Note newNote = noteService.getNoteById(note.getId());
		
		newNote.setNoteName(note.getNoteName());
		newNote.setNoteContent(note.getNoteContent());
		
		noteService.createNote(newNote);
		return "redirect:/main/notes/";
	}
	
	@GetMapping("delete/{id}")
	public String deleteNote(@PathVariable("id") long noteId) {
		noteService.deleteNote(noteId);
		return "redirect:/main/notes/";
	}
	
}
