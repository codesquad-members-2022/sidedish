package team14.sidedish.eventplanner;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventPlannerRepository extends CrudRepository<EventPlanner, Long> {
	// Between from, to 라서 durtion을 모르고서는 사용 x
	@Query("select MENU_ID, EVENT_ID from SIDEDISH_EVENT_PLANNER "
		+ "where START_DATE between date_sub(:date, interval EVENT_DURATION day) and :date\n"
		+ "and MENU_ID in (:menuIds)")
	List<EventPlannerDto.Id> findByOngoingEventAndMenuIdIn(LocalDate date, List<Long> menuIds);
}
