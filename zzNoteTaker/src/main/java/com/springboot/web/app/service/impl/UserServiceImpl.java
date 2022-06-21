package com.springboot.web.app.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.web.app.dto.UserRegistrationDto;
import com.springboot.web.app.exception.ResourceNotFoundException;
import com.springboot.web.app.model.Role;
import com.springboot.web.app.model.User;
import com.springboot.web.app.repository.UserRepository;
import com.springboot.web.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	  @Override
	   public User findByEmail(String email){
	       return userRepository.findByEmail(email);
	   }

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
			return userRepository.findAll();
		}


	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("User", "id", id));
	}

	@Override
	public User updateUser(User user, long id) {
		User existingUser = userRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User", "Id", id));

		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		// save existing user to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		//check if user exists in DB
		userRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User();
		
		user.setName(registrationDto.getName()); 
		user.setEmail(registrationDto.getEmail());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setRoles(Arrays.asList(new Role("USER")));
		
		return userRepository.save(user);
	}
	
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	


}
