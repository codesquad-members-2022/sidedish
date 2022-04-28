package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.EventTabs;

import java.util.Locale;

public class EventTabDto {

    private Integer id;
    private String name;
    private String type;

    public EventTabDto(EventTabs eventTabs) {
        this.id = eventTabs.getId();
        this.name = eventTabs.getDescription();
        this.type = eventTabs.getName().toLowerCase();
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
