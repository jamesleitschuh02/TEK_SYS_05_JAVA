package com.JamesLeitschuh.workspace.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.JamesLeitschuh.workspace.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);


}
