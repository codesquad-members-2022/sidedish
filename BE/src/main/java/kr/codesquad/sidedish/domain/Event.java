package kr.codesquad.sidedish.domain;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Event {

    @Id
    private String name;
    private String description;
    @MappedCollection(idColumn = "EVENT_ID", keyColumn = "ID")
    private List<Dish> dishes;

    public Event(String name, String description,
        List<Dish> dishes) {
        this.name = name;
        this.description = description;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
