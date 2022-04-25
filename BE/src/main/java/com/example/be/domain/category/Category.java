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

    @MappedCollection(idColumn = "category_id", keyColumn = "dish_id")
    private List<Dish> dishes = new ArrayList<>();

    @MappedCollection(idColumn = "category_id", keyColumn = "dish_id")
    private List<SubCategory> subCategories = new ArrayList<>();

    public Category(String title, List<Dish> dishes, List<SubCategory> subCategories) {
        this.title = title;
        this.dishes = dishes;
        this.subCategories = subCategories;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }
}
