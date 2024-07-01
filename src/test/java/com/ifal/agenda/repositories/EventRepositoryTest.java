package com.ifal.agenda.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ifal.agenda.entities.Event;
import com.ifal.agenda.tests.Factory;

@DataJpaTest
public class EventRepositoryTest {

	@Autowired
	private EventRepository repository;
	
	private long exitingId;
	private long notExistisId;
	private long countTotalEvents;
	
	@BeforeEach
	void setUp() throws Exception {
		exitingId = 1L;
		notExistisId = 1000L;
		countTotalEvents = 1L;
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		Event event = Factory.createEvent();
		event.setId(null);
		
		event = repository.save(event);
		
		Assertions.assertNotNull(event.getId());
		
	}
}
