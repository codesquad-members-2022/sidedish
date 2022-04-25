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
		List<OngoingEvent> ongoingEvents = eventRepository.findMenuOngoingByEventIdIn(eventIds);
		return getEventAndSalesDto(ongoingEvents);
	}

	/**
	 * ERD 참고, 이벤트를 통해 할인서비스가 제공됩니다.
	 * @param ongoingEvents
	 * @return
	 */
	private EventAndSalesDto getEventAndSalesDto(List<OngoingEvent> ongoingEvents) {
		List<Event> events = getEvents(ongoingEvents);
		List<SalePolicy> salePolicies = getSalePolicies(ongoingEvents);
		return new EventAndSalesDto(events, salePolicies);
	}

	private List<SalePolicy> getSalePolicies(List<OngoingEvent> ongoingEvents) {
		return ongoingEvents.stream()
			.map(ongoingEvent -> SalePolicy.of(ongoingEvent.getSaleTitle(), ongoingEvent.getSaleAmount(),
				ongoingEvent.getEventId()))
			.collect(Collectors.toList());
	}

	private List<Event> getEvents(List<OngoingEvent> ongoingEvents) {
		return ongoingEvents.stream()
			.map(ongoingEvent -> new Event(ongoingEvent.getEventId(), ongoingEvent.getEventTitle()))
			.collect(Collectors.toList());
	}
}
