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
import com.JamesLeitschuh.workspace.model.Task;
import com.JamesLeitschuh.workspace.repository.TaskRepository;
import com.JamesLeitschuh.workspace.service.TaskService;
import com.JamesLeitschuh.workspace.service.impl.TaskServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskServiceMethods {
	
	@TestConfiguration
	static class TaskServiceImplTestContextConfiguration {
		
		@Bean
		public TaskService taskService() {
			return new TaskServiceImpl();
		}
	}
	
	@Autowired
	TaskService taskService;
	
	@MockBean
	private TaskRepository taskRepo;
	
	@Before
	public void setUp() {
		Task task = new Task();
		List<Task> tasks = new ArrayList<>();
		tasks.add(task);
		
		Mockito.when(taskRepo.findAll()).thenReturn(tasks);
	}
	
	@Test
	public void getAllTasksTest() {
		List<Task> testTasks = taskService.getAllTasks();
		assertThat(testTasks).hasSize(1);
	}

}
