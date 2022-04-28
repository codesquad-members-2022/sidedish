package com.team34.sidedish.domain;

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
    private final List<Category> children;

    public Category(Long id, String name, boolean isEvent, Long parentCategoryId,
        List<Category> children) {
        this.id = id;
        this.name = name;
        this.isEvent = isEvent;
        this.parentCategoryId = parentCategoryId;
        this.children = children;
    }

    public void clearCategory() {
        children.clear();
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
