package com.springboot.workspace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.JamesLeitschuh.workspace.LeitschuhJamesWorkspaceCaseStudyApplication;
import com.JamesLeitschuh.workspace.model.Note;
import com.JamesLeitschuh.workspace.repository.NoteRepository;
import com.JamesLeitschuh.workspace.service.NoteService;
import com.JamesLeitschuh.workspace.service.impl.NoteServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NoteServiceTest {
	
	@TestConfiguration
	static class NoteServiceImplTestContextConfiguration {
		
		@Bean
		public NoteService noteService() {
			return new NoteServiceImpl();
		}
	}
	
	@Autowired
	NoteService noteService;
	
	@MockBean
	private NoteRepository noteRepo;
	
	@BeforeAll
	public void setUp() {
		Note note = new Note();
		List<Note> notes = new ArrayList<>();
		notes.add(note);
		
		Mockito.when(noteRepo.findAll()).thenReturn(notes);
	}
	
	
	@Test
	void getAllNotesTest() {
		List<Note> testNotes = noteService.getAllNotes();
		assertThat(testNotes).hasSize(1);
	}

}
