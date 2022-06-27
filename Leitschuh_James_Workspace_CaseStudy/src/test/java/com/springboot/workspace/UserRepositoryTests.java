package com.springboot.workspace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.JamesLeitschuh.workspace.LeitschuhJamesWorkspaceCaseStudyApplication;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
public class UserRepositoryTests {
	
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
	public void findByEmailTest() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		User user2 = userRepo.findByEmail(user.getEmail());
		assertEquals(user.getId(), user2.getId());
	}
	
	@ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    public void saveUserTest(String message) {
        assertNotNull(message);
    }
	
	@ParameterizedTest
    @CsvFileSource(resources = "/com/springboot/workspace/test-data.csv")
    public void saveUserTest(String firstName, String lastName, String email, String password, String city) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setCity(city);
        userRepo.save(user);
        
        User user2 = userRepo.findByEmail(user.getEmail());
        assertEquals(user, user2);
    }

}
