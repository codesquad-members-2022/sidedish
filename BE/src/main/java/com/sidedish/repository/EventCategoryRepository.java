package com.sidedish.repository;

import com.sidedish.domain.EventCategory;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {

    @Query("SELECT id, name FROM event_category WHERE event_id = :eventId")
    List<EventCategory> findAllByEventId(@Param("eventId") Integer eventId);

}
