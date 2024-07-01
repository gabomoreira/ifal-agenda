package com.ifal.agenda.dto;

import java.io.Serializable;
import java.time.Instant;

import com.ifal.agenda.entities.Event;

public class EventDTO implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String description;
	private Instant date;
	
	public EventDTO() {
		
	}

	public EventDTO(Long id, String title, String description, Instant date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
	}
	
	public EventDTO(Event entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.date = entity.getDate();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
}
