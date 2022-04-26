package team14.sidedish.eventplanner;

import static team14.sidedish.eventplanner.EventPlanner.EVENT_PLANNER_KEY;
import static team14.sidedish.eventplanner.EventPlanner.EVENT_PLANNER_KEY_MENU;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventPlannerService {
	private final EventPlannerRepository eventPlannerRepository;

	public EventPlannerDto.Ids readOngoingEventOf(List<Long> menuIds) {
		List<EventPlanner> eventPlanners = eventPlannerRepository.findByMenuIdIn(menuIds);
		LocalDate today = LocalDate.now();
		List<EventPlannerDto.Id> eventPlannerIds = getOngoingEvents(eventPlanners, today);
		return new EventPlannerDto.Ids(eventPlannerIds);
	}

	private List<EventPlannerDto.Id> getOngoingEvents(List<EventPlanner> eventPlanners, LocalDate today) {
		return eventPlanners.stream()
			.filter(planner -> (
				(planner.getStartDate().isAfter(today) || planner.getStartDate().equals(today))
				&& today.isBefore(planner.getStartDate().plusDays(planner.getDuration()))))
			.map(eventPlanner -> {
				Map<String, Long> menuAndEvent = eventPlanner.getMenuAndEvent();
				return new EventPlannerDto.Id(
					menuAndEvent.get(EVENT_PLANNER_KEY_MENU),
					menuAndEvent.get(EVENT_PLANNER_KEY));
			})
			.collect(Collectors.toList());
	}
}
