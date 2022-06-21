package com.springboot.web.app.service;

import java.util.List;

import com.springboot.web.app.model.Upcomming;

public interface UpcommingService {
	
	Upcomming createEvent(Upcomming event);
	
	List<Upcomming> getAllEvents();
	
	List<Upcomming> getAllEventsById(long id);
	
	Upcomming getEventById(long id);
	
	Upcomming updateEvent(Upcomming event, long id);
	
	void deleteEvent(long id);

}
