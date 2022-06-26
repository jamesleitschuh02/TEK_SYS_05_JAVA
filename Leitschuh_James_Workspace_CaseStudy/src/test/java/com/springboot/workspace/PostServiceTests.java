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
import com.JamesLeitschuh.workspace.model.Post;
import com.JamesLeitschuh.workspace.repository.PostRepository;
import com.JamesLeitschuh.workspace.service.PostService;
import com.JamesLeitschuh.workspace.service.impl.PostServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostServiceTests {
	
	@TestConfiguration
	static class PostServiceImplTestContextConfiguration {
		
		@Bean
		public PostService PostService() {
			return new PostServiceImpl();
		}
	}
	
	@Autowired
	PostService postService;
	
	@MockBean
	private PostRepository postRepo;
	
	@Before
	public void setUp() {
		Post post = new Post();
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		
		Mockito.when(postRepo.findAll()).thenReturn(posts);
	}
	
	
	@Test
	public void getAllPostsTest() {
		List<Post> testPosts = postService.getAllPosts();
		assertThat(testPosts).hasSize(1);
	}

}
