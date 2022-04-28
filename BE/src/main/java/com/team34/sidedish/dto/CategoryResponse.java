package com.team34.sidedish.dto;

import com.team34.sidedish.domain.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryResponse {

    private Long id;
    private String name;
    private List<CategoryResponse> children;

    public CategoryResponse(Long id, String name, List<CategoryResponse> children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.children = new ArrayList<>();
        for (Category c : category.getChildren()) {
            this.children.add(new CategoryResponse(c));
        }
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CategoryResponse> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", children=" + children +
            '}';
    }
}
