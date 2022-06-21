package com.JamesLeitschuh.workspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JamesLeitschuh.workspace.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query(
			value = "SELECT * FROM events WHERE events.user_id = ?1",
			nativeQuery = true)
	List<Event> findAllEventsById(long id);
	
	@Query(
			value = "SELECT * FROM events WHERE events.user_id = ?1 ORDER BY event_date",
			nativeQuery = true)
	List<Event> findAllEventsByIdOrdered(long id);

}
