package team14.sidedish.event;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
	@Query("select a.EVENT_ID, a.EVENT_TITLE, b.SALE_TITLE, b.SALE_AMOUNT from SIDEDISH_EVENTS a\n"
		+ "inner join SIDEDISH_SALE_POLICY b on a.EVENT_ID = b.EVENT_ID where a.EVENT_ID in (:eventId)")
	List<OngoingEvent> findMenuOngoingByEventIdIn(List<Long> eventId);
}

