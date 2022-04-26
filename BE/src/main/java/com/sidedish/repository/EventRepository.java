package com.sidedish.repository;

import com.sidedish.domain.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
