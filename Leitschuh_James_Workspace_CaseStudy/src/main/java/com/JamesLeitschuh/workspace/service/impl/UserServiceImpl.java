package com.JamesLeitschuh.workspace.service.impl;

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

import com.JamesLeitschuh.workspace.dto.UserRegistrationDto;
import com.JamesLeitschuh.workspace.exception.ResourceNotFoundException;
import com.JamesLeitschuh.workspace.model.Role;
import com.JamesLeitschuh.workspace.model.User;
import com.JamesLeitschuh.workspace.repository.UserRepository;
import com.JamesLeitschuh.workspace.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User();
		
		user.setFirstName(registrationDto.getFirstName()); 
		user.setLastName(registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		user.setCity(registrationDto.getCity());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setRoles(Arrays.asList(new Role("USER")));
		
		return userRepo.save(user);
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepo.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("User", "id", id));
	}

	@Override
	public User updateUser(User user, long id) {
		User existingUser = userRepo.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("User", "Id", id));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		
		// save existing user to DB
		userRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		//check if user exists in DB
		userRepo.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("User", "Id", id));
		userRepo.deleteById(id);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
