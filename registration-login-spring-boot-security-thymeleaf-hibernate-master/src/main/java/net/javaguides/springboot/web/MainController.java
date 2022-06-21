package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/test")
	public String test(Authentication authentication) {
		// get name - refers to login name
		System.out.println(authentication.getName());
		// how the system can access id number
		System.out.println(userService.findByEmail(authentication.getName()).getId());
		return "index";
	}
	
//	@GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }

}
