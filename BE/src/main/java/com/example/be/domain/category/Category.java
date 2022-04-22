package com.example.be.domain.category;

import com.example.be.domain.dish.Dish;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table("category")
public class Category {

    @Id
    private Long categoryId;
    private String title;

    @MappedCollection(idColumn = "dish_id", keyColumn = "dish_id")
    private List<Dish> dishes = new ArrayList<>();

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

}
