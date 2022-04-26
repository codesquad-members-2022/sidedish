package team14.sidedish.event;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import team14.sidedish.salepolicy.SalePolicy;

@RequiredArgsConstructor
@Service
public class EventService {
	private final EventRepository eventRepository;
	/**
	 * 현재 진행중인 이벤트의 menuId 에 해당하는 eventId 목록을 전달 받아, 해당 이벤트 정보를 조회 합니다.
	 * - 이벤트 배지 정보
	 * - 해당 이벤트에 대한 할인 정보
	 * @param eventIds
	 * @return
	 */
	public EventAndSalesDto read(List<Long> eventIds) {
		List<Event> events = eventRepository.findEventByEventIdIn(eventIds);
		return getEventAndSalesDto(events);
	}

	/**
	 * ERD 참고, 이벤트를 통해 할인서비스가 제공됩니다.
	 * @param ongoingEventInfos
	 * @return
	 */
	private EventAndSalesDto getEventAndSalesDto(List<Event> ongoingEventInfos) {
		List<Event> events = getEvents(ongoingEventInfos);
		List<SalePolicy> salePolicies = getSalePolicies(ongoingEventInfos);
		return new EventAndSalesDto(events, salePolicies);
	}

	private List<SalePolicy> getSalePolicies(List<Event> events) {
		return events.stream()
			.map(event ->
				event.getSalePolicies().stream()
				.map(salePolicy -> SalePolicy.of(salePolicy.policy(), salePolicy.discountAmount(), event.getEventId()))
				.collect(Collectors.toList())
			).flatMap(salePolicies -> salePolicies.stream())
			.collect(Collectors.toList());
	}

	private List<Event> getEvents(List<Event> events) {
		return events.stream()
			.map(event -> new Event(event.getEventId(), event.title()))
			.collect(Collectors.toList());
	}
}
