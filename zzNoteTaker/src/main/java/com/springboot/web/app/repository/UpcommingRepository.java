package com.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.web.app.model.Upcomming;

public interface UpcommingRepository extends JpaRepository<Upcomming, Long> {
	
	@Query(
	value = "SELECT * FROM upcomming WHERE upcomming.user_id = ?1", 
	nativeQuery = true)
	List<Upcomming> findAllUpcommingById(long id);

}
