package com.ifal.agenda.tests;

import java.time.Instant;

import com.ifal.agenda.dto.EventDTO;
import com.ifal.agenda.entities.Event;

public class Factory {

	public static Event createEvent() {
		Event event = new Event(1L, "Show no Jaraguá", "Os shows do São João Massayó", Instant.parse("2024-06-29T22:30:00.22345Z"));
		
		return event;
	}
	
	public static EventDTO createEventDTO() {
		Event event = createEvent();
				
		return new EventDTO(event);
	}
}
