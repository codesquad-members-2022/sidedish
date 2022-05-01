package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Event;

import java.util.List;
import java.util.stream.Collectors;

public class EventTabListDto {

    private List<EventTabDto> eventTabs;

    public EventTabListDto(List<Event> events) {
        this.eventTabs = makeEvent(events);
    }

    private List<EventTabDto> makeEvent(List<Event> events) {
        return events.stream()
                .map(EventTabDto::new)
                .collect(Collectors.toList());
    }

    public List<EventTabDto> getEventTabs() {
        return eventTabs;
    }

}
