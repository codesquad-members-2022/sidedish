package com.team34.sidedish.dto;

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
