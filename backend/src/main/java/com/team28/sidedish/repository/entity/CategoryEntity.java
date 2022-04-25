package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table("CATEGORY")
public class CategoryEntity {

    @Id
    private Long id;
    private String code;
    private String name;
}
