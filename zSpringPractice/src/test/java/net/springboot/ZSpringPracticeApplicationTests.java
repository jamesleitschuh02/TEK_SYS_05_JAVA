package net.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ZSpringPracticeApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private MvcController mvcController;
	
	@Test
	void contextLoads() {
		assertThat(mvcController).isNotNull();
	}
	
	@Test
	void testHello() throws Exception {
		mockMvc.perform(get("/hello"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Greetings message from controller")));
	}
	
	@Test
	void testHome() throws Exception {
		mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	void testRest() throws Exception {
		mockMvc.perform(get("/rest"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello Rest")));
	}

}
