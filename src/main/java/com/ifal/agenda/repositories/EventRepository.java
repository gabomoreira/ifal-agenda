package com.ifal.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifal.agenda.entities.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
