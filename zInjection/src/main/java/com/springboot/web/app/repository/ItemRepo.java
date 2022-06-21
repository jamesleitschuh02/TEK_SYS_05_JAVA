package com.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.web.app.entity.Item;

public interface ItemRepo extends CrudRepository<Item, Integer> {

	
	//Custom Queries
	
//	@Query("SELECT")
	List<Item> findByItemId(int item_id);
}
