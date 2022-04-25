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
		List<OngoingEventInfo> ongoingEventInfos = eventRepository.findMenuOngoingByEventIdIn(eventIds);
		return getEventAndSalesDto(ongoingEventInfos);
	}

	/**
	 * ERD 참고, 이벤트를 통해 할인서비스가 제공됩니다.
	 * @param ongoingEventInfos
	 * @return
	 */
	private EventAndSalesDto getEventAndSalesDto(List<OngoingEventInfo> ongoingEventInfos) {
		List<Event> events = getEvents(ongoingEventInfos);
		List<SalePolicy> salePolicies = getSalePolicies(ongoingEventInfos);
		return new EventAndSalesDto(events, salePolicies);
	}

	private List<SalePolicy> getSalePolicies(List<OngoingEventInfo> ongoingEventInfos) {
		return ongoingEventInfos.stream()
			.map(ongoingEventInfo -> SalePolicy.of(ongoingEventInfo.getSaleTitle(), ongoingEventInfo.getSaleAmount(),
				ongoingEventInfo.getEventId()))
			.collect(Collectors.toList());
	}

	private List<Event> getEvents(List<OngoingEventInfo> ongoingEventInfos) {
		return ongoingEventInfos.stream()
			.map(ongoingEventInfo -> new Event(ongoingEventInfo.getEventId(), ongoingEventInfo.getEventTitle()))
			.collect(Collectors.toList());
	}
}
