package com.springboot.workspace;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.JamesLeitschuh.workspace.LeitschuhJamesWorkspaceCaseStudyApplication;
import com.JamesLeitschuh.workspace.model.Note;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.repository.NoteRepository;
import com.JamesLeitschuh.workspace.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
public class NoteRepositoryTests {
	
	@Autowired
	NoteRepository noteRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@BeforeEach
	public void setUp() {
		System.out.println("\n>>inside setUp, starting new test\n");
	}
	
	@AfterEach
	public void cleanUp() {
		System.out.println("\n>>inside cleanUp, stopping all tests\n");
	}
	
	@Test
	public void practiceTest() {
		System.out.println(">>inside practice test");
	}
	
	@Test
	public void findAllNotesByIdTest() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		Note note = new Note();
		note.setUser(user);
		noteRepo.save(note);
		
		List<Note> results = noteRepo.findAllNotesById(user.getId());
		assertEquals(results.size(), 1);
	}

}
