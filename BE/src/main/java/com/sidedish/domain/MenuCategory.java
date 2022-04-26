package com.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table("menu_category")
public class MenuCategory {

    @Id
    private Integer id;
    private String name;
}
