package team31.codesuqad.sidedish.controller.dto;

import java.util.List;

public class EventTabListDto {

    private final List<EventTabDto> categorynames;

    public EventTabListDto(List<EventTabDto>  eventTabList) {
        categorynames = eventTabList;
    }

    public List<EventTabDto> getCategorynames() {
        return categorynames;
    }

}
