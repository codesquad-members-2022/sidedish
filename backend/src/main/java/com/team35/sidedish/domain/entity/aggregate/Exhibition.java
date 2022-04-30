package com.team35.sidedish.domain.entity.aggregate;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Exhibition {

    @Id
    private long id;
    private String title;

    @MappedCollection(idColumn = "exhibition_id", keyColumn = "id")
    private List<Category> categories;

    @Override
    public String toString() {
        return "Exhibition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                '}';
    }
}
