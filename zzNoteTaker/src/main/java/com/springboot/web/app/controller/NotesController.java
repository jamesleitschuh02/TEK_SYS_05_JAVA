package com.springboot.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.model.Notes;
import com.springboot.web.app.model.User;
import com.springboot.web.app.service.NotesService;
import com.springboot.web.app.service.UserService;

@Controller
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String getNewNotePage(Model model) {
		Notes note = new Notes();
		model.addAttribute("note", note);
		
		boolean newNote = true;
		model.addAttribute("newNote", newNote);
		
		return "new-updateNote";
	}
	
	@PostMapping("/create")
	public String saveNote(@ModelAttribute("note") Notes note, Authentication authentication) {
		
//		long id = userService.findByEmail(authentication.getName()).getId();
		User user = userService.findByEmail(authentication.getName());
		note.setUser(user);
		
		notesService.createNote(note);
		return "redirect:/main/notes/";
	}
	
	@GetMapping("/update/{id}")
	public String updateNote(Model model, @PathVariable("id") long noteId) {	
		Notes note = notesService.getNoteById(noteId);			
		model.addAttribute("note", note);
		
		boolean newNote = false;
		model.addAttribute("newNote", newNote);
		
		return "new-updateNote";
	}

	
	@PostMapping("/saveUpdates")
	public String saveNoteUpdates(@ModelAttribute("note") Notes note) {

		Notes newNote = notesService.getNoteById(note.getId());
		
		newNote.setNoteName(note.getNoteName());
		newNote.setNoteContent(note.getNoteContent());
		
		System.out.println("\nNOTE CONTENT:");
		System.out.println(note.getId());
		System.out.println(note.getNoteName());
		System.out.println(note.getNoteContent());
		
		System.out.println("\nUSER CONTENT:");
		System.out.println(newNote.getUser().getId());
		System.out.println(newNote.getUser().getId());
		System.out.println(newNote.getUser().getName());
		System.out.println(newNote.getUser().getEmail());
		
		notesService.createNote(newNote);
		return "redirect:/main/notes/";
	}
	
	@GetMapping("/testUpdate/{id}/{title}/{content}")
	public String testUpdate(@PathVariable("id") long id, 
							 @PathVariable("title") String title, 
							 @PathVariable("content") String content) {
		Notes newNote = notesService.getNoteById(id);
		newNote.setNoteName(title);
		newNote.setNoteContent(content);
		notesService.createNote(newNote);
		return "redirect:/main/notes";
	}
	
	@GetMapping("delete/{id}")
	public String deleteNote(@PathVariable("id") long noteId) {
		notesService.deleteNote(noteId);
		return "redirect:/main/notes/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	// create Note
//	@PostMapping("/create")
//	public ResponseEntity<Notes> createNote(@RequestBody Notes note){
//		return new ResponseEntity<Notes>(
//				notesService.createNote(note),
//				HttpStatus.CREATED);
//	}
//		
//	// get all Notes
//	@GetMapping("/getall")
//	public List<Notes> getAllNote(){
//		return notesService.getAllNotes();
//			
//	}
//
//
//	// get Note by ID
//	@GetMapping("/{id}")
//	public ResponseEntity<Notes> getNoteById(@PathVariable("id") long noteId) {
//		return new ResponseEntity<Notes>(
//				notesService.getNoteById(noteId),
//				HttpStatus.OK);
//	}
//		
//	// update Note
//	@PutMapping("{id}")
//	public ResponseEntity<Notes> updateNote(
//			@PathVariable("id") long noteId, @RequestBody Notes note) {
//		return new ResponseEntity<Notes>(
//				notesService.updateNote(note, noteId),
//				HttpStatus.OK);
//	}
//		
//	// delete Note
//	@DeleteMapping("{id}")
//	public ResponseEntity<String> deleteNote(@PathVariable("id") long id) {
//		notesService.deleteNote(id);
//		return new ResponseEntity<String>("Note Deleted", HttpStatus.OK);
//	}

}
