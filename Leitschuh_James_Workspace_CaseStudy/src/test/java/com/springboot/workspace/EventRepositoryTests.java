package com.springboot.workspace;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.JamesLeitschuh.workspace.LeitschuhJamesWorkspaceCaseStudyApplication;
import com.JamesLeitschuh.workspace.model.Event;
import com.JamesLeitschuh.workspace.repository.EventRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
public class EventRepositoryTests {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Test
	public void practiceTest() {
		System.out.println(">>inside practice test");
	}
	
	@Test
	public void findAllEventsByIdOrderedTest() {
		List<Event> result = eventRepo.findAllEventsByIdOrdered(1);
		assertEquals(result.size(), 0);
	}

}
