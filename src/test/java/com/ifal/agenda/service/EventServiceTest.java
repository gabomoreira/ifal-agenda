package com.ifal.agenda.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ifal.agenda.entities.Event;
import com.ifal.agenda.repositories.EventRepository;
import com.ifal.agenda.tests.Factory;

@ExtendWith(SpringExtension.class)
public class EventServiceTest {

	@InjectMocks
	private EventService service;
	
	@Mock
	private EventRepository repository;
	
	private long existingId;
	private long notExisting;
	private Event event;
	
	@BeforeEach
	void setUp() {
		existingId = 1L;
		notExisting = 2L;
		event = Factory.createEvent();
		
		Mockito.when(repository.save(ArgumentMatchers.any(Event.class))).thenReturn(event);
	}
	
	@Test
	public void saveShouldReturnEvent() {
		Event eventCreated = repository.save(event);
		
		assertThat(eventCreated.getTitle()).isSameAs(event.getTitle());
		verify(repository).save(event);
	}
}
