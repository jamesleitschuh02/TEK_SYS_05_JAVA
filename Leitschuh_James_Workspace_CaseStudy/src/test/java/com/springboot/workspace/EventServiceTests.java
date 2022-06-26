package com.springboot.workspace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
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
import com.JamesLeitschuh.workspace.model.Event;
import com.JamesLeitschuh.workspace.repository.EventRepository;
import com.JamesLeitschuh.workspace.service.EventService;
import com.JamesLeitschuh.workspace.service.impl.EventServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EventServiceTests {
	
	@TestConfiguration
	static class EventServiceImplTestContextConfiguration {
		
		@Bean
		public EventService eventService() {
			return new EventServiceImpl();
		}
	}
	
	@Autowired
	EventService eventService;
	
	@MockBean
	private EventRepository eventRepo;
	
	@Before
	public void setUp() {
		Event event = new Event();
		List<Event> events = new ArrayList<>();
		events.add(event);
		
		Mockito.when(eventRepo.findAll()).thenReturn(events);
	}
	
	
	@Test
	public void getAllEventsTest() {
		List<Event> testEvents = eventService.getAllEvents();
		assertThat(testEvents).hasSize(1);
	}

}
