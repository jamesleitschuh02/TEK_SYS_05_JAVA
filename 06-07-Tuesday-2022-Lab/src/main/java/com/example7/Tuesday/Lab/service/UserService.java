package com.example7.Tuesday.Lab.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example7.Tuesday.Lab.UserRegistrationDto;
import com.example7.Tuesday.Lab.entity.User;

public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
}