package kr.codesquad.sidedish.domain;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Event {
 
    @Id
    private Long id;
    private String name;
    private String description;
    @MappedCollection(idColumn = "EVENT_ID", keyColumn = "ID")
    private List<Dish> dishes;

    public Event(Long id, String name, String description,
        List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
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
