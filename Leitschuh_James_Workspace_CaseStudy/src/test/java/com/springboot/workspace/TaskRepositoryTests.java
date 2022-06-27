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
import com.JamesLeitschuh.workspace.model.Task;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.repository.TaskRepository;
import com.JamesLeitschuh.workspace.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepositoryTests {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@BeforeEach
	public void setUp() {
		System.out.println("\n>>inside setUp, starting new test\n");
	}
	
	@AfterEach
	public void cleanUp() {
		System.out.println("\n>>inside cleanUp, end of test\n");
	}
	
	@Test
	public void practiceTest() {
		System.out.println(">>inside practice test");
	}
	
	@Test
	public void findAllTasksByIdTest() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		Task task = new Task();
		task.setUser(user);
		taskRepo.save(task);
		
		List<Task> result = taskRepo.findAllTasksById(user.getId());
		assertEquals(result.size(), 1);
	}
	
	@Test
	public void findAllIncompleteTasksByIdTest() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		Task task = new Task();
		task.setUser(user);
		taskRepo.save(task);
		
		Task task2 = new Task();
		task2.setUser(user);
		task2.setCompleted(true);
		taskRepo.save(task2);
		
		List<Task> result = taskRepo.findAllIncompleteTasksById(user.getId());
		assertEquals(result.size(), 1);
		
	}

}
