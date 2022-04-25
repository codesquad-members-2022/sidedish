package com.codesquad.sidedish.category.domain;

import java.util.Set;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@ToString
public class Category {

    @Id
    @Column("category_id")
    private Integer id;

    private Integer sectionId;
    private String categoryName;
    private Boolean isFestival;

    @MappedCollection(idColumn = "category_id")
    private Set<DishRef> dishes;

}
