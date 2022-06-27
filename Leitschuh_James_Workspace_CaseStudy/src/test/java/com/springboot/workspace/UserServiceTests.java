package com.springboot.workspace;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.repository.UserRepository;
import com.JamesLeitschuh.workspace.service.UserService;
import com.JamesLeitschuh.workspace.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTests {
	
	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {
		
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}
	
	@Autowired
	UserService userService;
	
	@MockBean
	private UserRepository userRepo;
	
	@Before
	public void setUp() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);
		
		Mockito.when(userRepo.findAll()).thenReturn(users);
	}
	
	
	@Test
	public void getAllUsersTest() {
		List<User> testUsers = userService.getAllUsers();
		assertThat(testUsers).hasSize(1);
	}
	
}
