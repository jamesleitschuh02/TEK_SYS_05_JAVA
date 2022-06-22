package com.springboot.workspace;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.JamesLeitschuh.workspace.LeitschuhJamesWorkspaceCaseStudyApplication;
import com.JamesLeitschuh.workspace.controller.MainController;
import com.JamesLeitschuh.workspace.controller.NoteController;
import com.JamesLeitschuh.workspace.controller.CommentController;
import com.JamesLeitschuh.workspace.controller.EventController;
import com.JamesLeitschuh.workspace.controller.PostController;
import com.JamesLeitschuh.workspace.controller.TaskController;
import com.JamesLeitschuh.workspace.controller.UserController;

@SpringBootTest(classes = LeitschuhJamesWorkspaceCaseStudyApplication.class)
class LeitschuhJamesWorkspaceCaseStudyApplicationTests {
	
	@Autowired
	private MainController mainController;
	
	@Autowired
	private NoteController noteController;
	
	
	@Autowired
	private CommentController commentController;
	
	
	@Autowired
	private EventController eventController;
	
	
	@Autowired
	private PostController postController;
	
	
	@Autowired
	private TaskController taskController;
	
	
	@Autowired
	private UserController userController;
	
	

	// Tests if application context starts
	
	@Test
	void contextLoads() {
	}
	
	
	// Following tests application context is creating controllers
	
	@Test
	void contextLoadsMainController() throws Exception {
		assertThat(mainController).isNotNull();
	}

	
	@Test
	void contextLoadsNoteController() throws Exception {
		assertThat(noteController).isNotNull();
	}
	
	
	@Test
	void contextLoadsCommentController() throws Exception {
		assertThat(commentController).isNotNull();
	}
	
	
	@Test
	void contextLoadsEventController() throws Exception {
		assertThat(eventController).isNotNull();
	}
	
	
	@Test
	void contextLoadsPostController() throws Exception {
		assertThat(postController).isNotNull();
	}
	
	
	@Test
	void contextLoadsTaskController() throws Exception {
		assertThat(taskController).isNotNull();
	}
	
	
	@Test
	void contextLoadsUserController() throws Exception {
		assertThat(userController).isNotNull();
	}
	
	
}
