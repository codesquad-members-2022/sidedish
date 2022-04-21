package com.codesquad.sidedish.other.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@ToString
public class Category {

    @Id
    @Column("category_id")
    private Integer id;

    private Integer sectionId;
    private String categoryName;
    private Boolean isFestival;
}
