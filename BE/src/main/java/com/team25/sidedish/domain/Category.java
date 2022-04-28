package com.team25.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Category {
    @Id
    private Long id;
    private final String name;
    private final int productCount;

    public Category(String name, int productCount) {
        this.name = name;
        this.productCount = productCount;
    }
}
