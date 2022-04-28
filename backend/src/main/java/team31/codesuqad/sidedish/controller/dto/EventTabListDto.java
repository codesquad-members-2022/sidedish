package team31.codesuqad.sidedish.controller.dto;

import java.util.List;

public class EventTabListDto {

    private final List<EventTabDto> eventTabs;

    public EventTabListDto(List<EventTabDto>  eventTabList) {
        eventTabs = eventTabList;
    }

    public List<EventTabDto> getEventTabs() {
        return eventTabs;
    }

}
