package com.JamesLeitschuh.workspace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JamesLeitschuh.workspace.exception.ResourceNotFoundException;
import com.JamesLeitschuh.workspace.model.Event;
import com.JamesLeitschuh.workspace.repository.EventRepository;
import com.JamesLeitschuh.workspace.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepo;

	@Override
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	@Override
	public List<Event> getAllEventsById(long id) {
		return eventRepo.findAllEventsById(id);
	}

	@Override
	public Event getEventById(long id) {
		return eventRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Event", "id", id));
	}

	@Override
	public Event updateEvent(Event event, long id) {
		Event existingEvent = eventRepo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Event", "Id", id));

		existingEvent.setEventName(event.getEventName());
		existingEvent.setEventDate(event.getEventDate());

		eventRepo.save(existingEvent);
		return existingEvent;
	}

	@Override
	public void deleteEvent(long id) {
		eventRepo.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Event", "Id", id));
		eventRepo.deleteById(id);
		
	}

}
