package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Event;

public class EventTabDto {

    private final Integer id;
    private final String name;
    private final String type;

    public EventTabDto(Event event) {
        this.id = event.getId();
        this.name = event.getDescription();
        this.type = event.getName().toLowerCase();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
