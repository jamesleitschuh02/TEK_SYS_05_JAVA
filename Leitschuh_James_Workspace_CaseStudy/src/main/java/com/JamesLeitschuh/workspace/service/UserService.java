package com.JamesLeitschuh.workspace.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.JamesLeitschuh.workspace.dto.UserRegistrationDto;
import com.JamesLeitschuh.workspace.model.User;

public interface UserService extends UserDetailsService {
	
	User findByEmail(String email);
	
	User save(UserRegistrationDto registrationDto);
	
	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	User updateUser(User user, long id);
	
	void deleteUser(long id);

}
