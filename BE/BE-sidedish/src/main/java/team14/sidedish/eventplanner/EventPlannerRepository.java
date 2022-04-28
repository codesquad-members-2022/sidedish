package team14.sidedish.eventplanner;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventPlannerRepository extends CrudRepository<EventPlanner, Long> {
	List<EventPlanner> findByMenuIdIn(List<Long> menuIds);
}

/**
 *  조회결과가 있어야 하는데, null 로 나옵니다.  이유를 모르겠어욤.
 */
/*	@Query("select MENU_ID, EVENT_ID from SIDEDISH_EVENT_PLANNER "
		+ "where START_DATE >= date_sub( :date, interval EVENT_DURATION day) and START_DATE <= :date and MENU_ID in ( :menuIds )")
	List<EventPlannerDto.Id> findByOngoingEventAndMenuIdIn(@Param("date") LocalDate date, @Param("menuIds") List<Long> menuIds);*/
