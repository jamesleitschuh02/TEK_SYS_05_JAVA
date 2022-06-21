package com.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
