package com.team34.sidedish.domain;

import com.team34.sidedish.dto.CategoryResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Category {

    @Id
    private Long id;

    private String name;
    private boolean isEvent;
    private Long parentCategoryId;

    @MappedCollection(idColumn = "parent_category_id", keyColumn = "id")
    private List<Category> children = new ArrayList<>();

    public Category(Long id, String name, boolean isEvent, Long parentCategoryId,
        List<Category> children) {
        this.id = id;
        this.name = name;
        this.isEvent = isEvent;
        this.parentCategoryId = parentCategoryId;
        this.children = children;
    }

    public void addCategory(Long id, String name, boolean isEvent, Long parentCategoryId,
        List<Category> children) {
        children.add(new Category(id, name, isEvent, parentCategoryId, children));
    }

    public void clearCategory() {
        children.clear();
    }

    public CategoryResponse toCategoryResponse() {
        if (children.isEmpty()) {
            return new CategoryResponse(id, name, new ArrayList<CategoryResponse>());
        }
        ArrayList<CategoryResponse> childrenCategories = new ArrayList<>();
        for (Category category : children) {
            childrenCategories.add(category.toCategoryResponse());
        }
        return new CategoryResponse(id, name, childrenCategories);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEvent() {
        return isEvent;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public List<Category> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", isEvent=" + isEvent +
            ", parentCategoryId=" + parentCategoryId +
            ", children=" + children +
            '}';
    }
}
