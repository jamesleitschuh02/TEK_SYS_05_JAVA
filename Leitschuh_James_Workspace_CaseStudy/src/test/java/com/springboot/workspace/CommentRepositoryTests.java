package com.springboot.workspace;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.JamesLeitschuh.workspace.LeitschuhJamesWorkspaceCaseStudyApplication;
import com.JamesLeitschuh.workspace.model.Comment;
import com.JamesLeitschuh.workspace.model.Post;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.repository.CommentRepository;
import com.JamesLeitschuh.workspace.repository.PostRepository;
import com.JamesLeitschuh.workspace.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommentRepositoryTests {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@BeforeEach
	public void setUp() {
		System.out.println(">>inside setUp, starting new test");
	}
	
	@AfterEach
	public void cleanUp() {
		System.out.println(">>inside cleanUp, stopping all tests");
	}	
	
	@Test
	public void saveTest() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		Post post = new Post();
		post.setPostName("insideTest");
		post.setPostDesc("insideTest");
		post.setUser(user);
		postRepo.save(post);
		
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setPosts(post);
		commentRepo.save(comment);
		
		
		Optional<Comment> found = commentRepo.findById(comment.getId());
		assertEquals(found.get().getId(), comment.getId());
	}
	
	@Test
	public void findAllCommentsById() {
		
		User user = new User();
		user.setFirstName("insideTest");
		user.setLastName("insdieTest");
		user.setEmail("insideTest");
		user.setPassword("insideTest");
		userRepo.save(user);
		
		Post post = new Post();
		post.setPostName("insideTest");
		post.setPostDesc("insideTest");
		post.setUser(user);
		postRepo.save(post);
		
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setPosts(post);
		commentRepo.save(comment);
		
		List<Comment> results = commentRepo.findAllCommentsById(post.getId());
		assertEquals(results.size(), 1);
		
	}

}
