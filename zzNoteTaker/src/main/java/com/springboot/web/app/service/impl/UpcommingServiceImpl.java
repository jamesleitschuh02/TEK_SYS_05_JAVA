package com.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.exception.ResourceNotFoundException;
import com.springboot.web.app.model.Notes;
import com.springboot.web.app.model.Upcomming;
import com.springboot.web.app.repository.UpcommingRepository;
import com.springboot.web.app.service.UpcommingService;

@Service
public class UpcommingServiceImpl implements UpcommingService{

	@Autowired
	private UpcommingRepository upcommingRepo;

	@Override
	public Upcomming createEvent(Upcomming event) {
		return upcommingRepo.save(event);
	}

	@Override
	public List<Upcomming> getAllEvents() {
		return upcommingRepo.findAll();
	}
	
	@Override
	public List<Upcomming> getAllEventsById(long id) {
		return upcommingRepo.findAllUpcommingById(id);
	}

	@Override
	public Upcomming getEventById(long id) {
		return upcommingRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Event", "id", id));
	}

	@Override
	public Upcomming updateEvent(Upcomming event, long id) {
		Upcomming existingEvent = upcommingRepo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Event", "Id", id));

		existingEvent.setEventName(event.getEventName());
		existingEvent.setEventDate(event.getEventDate());

		upcommingRepo.save(existingEvent);
		return existingEvent;
	}

	@Override
	public void deleteEvent(long id) {
		upcommingRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Event", "Id", id));
		upcommingRepo.deleteById(id);
		
	}
	
}
