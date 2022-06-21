package com.springboot.web.app.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.web.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// @Query("SELECT user FROM userTable")
	List<User> findByUserName(String user);

}
