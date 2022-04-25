package com.example.be.domain.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.LinkedList;
import java.util.List;

@Table("category")
public class Category {

    @Id
    private Long categoryId;
    private String description;

    @MappedCollection(idColumn = "category_id", keyColumn = "dish_id")
    private List<SubCategory> subCategories;

    @PersistenceConstructor
    public Category(String description, List<SubCategory> subCategories) {
        this.description = description;
        this.subCategories = new LinkedList<>(subCategories);
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }
}
