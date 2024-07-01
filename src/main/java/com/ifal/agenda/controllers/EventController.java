package com.ifal.agenda.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifal.agenda.dto.EventDTO;
import com.ifal.agenda.service.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventController {
	
	@Autowired
	private EventService service;	
	
	@PostMapping
	public ResponseEntity<EventDTO> insert(@RequestBody EventDTO eventDto) {
		eventDto = service.insert(eventDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(eventDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(eventDto);
	}
}
