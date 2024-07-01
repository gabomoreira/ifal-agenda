package com.ifal.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifal.agenda.dto.EventDTO;
import com.ifal.agenda.entities.Event;
import com.ifal.agenda.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	@Transactional
	public EventDTO insert(EventDTO eventDto) {
		Event event = new Event();
		event.setTitle(eventDto.getTitle());
		event.setDescription(eventDto.getDescription());
		event.setDate(eventDto.getDate());
		event = repository.save(event);
		
		return new EventDTO(event);
	}
}
