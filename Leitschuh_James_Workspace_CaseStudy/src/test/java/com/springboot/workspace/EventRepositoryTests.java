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
import com.JamesLeitschuh.workspace.model.Event;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.repository.EventRepository;
import com.JamesLeitschuh.workspace.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
public class EventRepositoryTests {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
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
	public void findAllEventsByIdTest() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		Event event = new Event();
		event.setUser(user);
		eventRepo.save(event);
		
		List<Event> result = eventRepo.findAllEventsById(user.getId());
		assertEquals(result.size(), 1);
	}
	
	@Test
	public void findAllEventsByIdOrderedTest() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		Event event = new Event();
		event.setUser(user);
		eventRepo.save(event);
		
		List<Event> results = eventRepo.findAllEventsByIdOrdered(user.getId());
		assertEquals(results.size(), 1);
	}

}
