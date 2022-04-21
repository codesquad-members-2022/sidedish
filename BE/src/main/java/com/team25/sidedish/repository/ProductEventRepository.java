package com.team25.sidedish.repository;

import com.team25.sidedish.domain.Event;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductEventRepository extends CrudRepository<Event, Long> {

    @Query("SELECT E.ID, E.NAME, E.DISCOUNT_RATE "
        + " FROM EVENT AS E"
        + " JOIN"
        + " ("
        + "     SELECT EVENT_ID"
        + "     FROM PRODUCT_EVENT"
        + "     WHERE PRODUCT_ID = :productId"
        + " )"
        + " AS R ON E.ID = R.EVENT_ID")
    Optional<List<Event>> findEventsByProductId(@Param("productId") Long productId);
}
