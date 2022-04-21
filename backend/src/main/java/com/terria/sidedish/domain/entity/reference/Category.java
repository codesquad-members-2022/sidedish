package com.terria.sidedish.domain.entity.reference;

import com.terria.sidedish.domain.entity.link.CategoryHasSideDish;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    private long id;
    private String title;
    private long exhibitionId;

    @MappedCollection(idColumn = "category_id")
    private Set<CategoryHasSideDish> categoryHasSideDishes;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", exhibitionId=" + exhibitionId +
                ", categoryHasSideDishes=" + categoryHasSideDishes +
                '}';
    }
}
