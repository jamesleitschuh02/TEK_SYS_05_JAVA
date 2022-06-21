package com.JamesLeitschuh.workspace.service;

import java.util.List;

import com.JamesLeitschuh.workspace.model.Event;

public interface EventService {
	
	Event createEvent(Event event);
	
	List<Event> getAllEvents();
	
	List<Event> getAllEventsById(long id);
	
	List<Event> getAllEventsByIdOrdered(long id);
	
	Event getEventById(long id);
	
	Event updateEvent(Event event, long id);
	
	void deleteEvent(long id);

}
