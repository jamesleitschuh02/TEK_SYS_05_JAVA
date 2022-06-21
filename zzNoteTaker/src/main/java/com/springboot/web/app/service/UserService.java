package com.springboot.web.app.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.web.app.dto.UserRegistrationDto;
import com.springboot.web.app.model.User;

public interface UserService extends UserDetailsService {
	
	User findByEmail(String email);
	
	User save(UserRegistrationDto registrationDto);
	
	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	User updateUser(User user, long id);
	
	void deleteUser(long id);
}
