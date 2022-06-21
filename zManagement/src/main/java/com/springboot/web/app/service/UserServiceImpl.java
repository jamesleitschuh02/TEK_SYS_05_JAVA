package com.springboot.web.app.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.springboot.web.app.model.User;

public interface UserServiceImpl {
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	List<User> getUserByName(String userName);
	
	Optional<User> getUsernameById(long id);
	
	void updateUser(long id, User user);
	
	void addUser(User user);
	
	void deleteUser(long id);
	
	void saveUser(User user);
}
