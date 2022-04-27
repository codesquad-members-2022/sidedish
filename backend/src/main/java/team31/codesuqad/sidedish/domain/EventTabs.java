package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class EventTabs {

    @Id
    Integer id;

    String name;
    String description;

    public EventTabs(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
