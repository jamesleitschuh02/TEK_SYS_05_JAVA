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
import com.JamesLeitschuh.workspace.model.Comment;
import com.JamesLeitschuh.workspace.repository.CommentRepository;
import com.JamesLeitschuh.workspace.service.CommentService;
import com.JamesLeitschuh.workspace.service.impl.CommentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommentServiceTests {
	
	@TestConfiguration
	static class CommentServiceImplTestContextConfiguration {
		
		@Bean
		public CommentService commentService() {
			return new CommentServiceImpl();
		}
	}
	
	@Autowired
	CommentService commentService;
	
	@MockBean
	private CommentRepository commentRepo;
	
	@Before
	public void setUp() {
		Comment comment = new Comment();
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		
		Mockito.when(commentRepo.findAll()).thenReturn(comments);
	}
	
	
	@Test
	public void getAllCommentsTest() {
		List<Comment> testComments = commentService.getAllComments();
		assertThat(testComments).hasSize(1);
	}

}
