package com.springboot.web.app.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.model.User;
import com.springboot.web.app.respositories.UserRepository;

@Service
public class UserService implements UserServiceImpl{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	// Don't use this function, ever
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> getUserByName(String userName) {
		return userRepo.findByUserName(userName);
	}

	@Override
	public Optional<User> getUsernameById(long id) {
		return userRepo.findById(id);
	}

	@Override
	public void updateUser(long id, User user) {
		User newUser = userRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No such user" + id));
		
		newUser.setUserName(user.getUserName());
		newUser.setDesc(user.getDesc());
		newUser.setActive(user.isActive());
		
		userRepo.save(newUser);
	}

	@Override
	public void addUser(User user) {
//		User newUser = new User();
//		newUser.setUserName(user.getUserName());
//		newUser.setDesc(user.getDesc());
//		newUser.setTargetDate(user.getTargetDate());
//		
//		userRepo.save(newUser);
		
		userRepo.save(user);
	}

	@Override
	public void deleteUser(long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			userRepo.delete(user.get());
		}	
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
