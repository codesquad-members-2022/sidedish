package team14.sidedish.eventplanner;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventPlannerService {
	private final EventPlannerRepository eventPlannerRepository;

	public EventPlannerDto.Ids readOngoingEventOf(List<Long> menuIds) {
		List<EventPlannerDto.Id> eventPlannerIds = eventPlannerRepository.findByOngoingEventAndMenuIdIn(LocalDate.now(), menuIds);
		return new EventPlannerDto.Ids(eventPlannerIds);
	}
}
