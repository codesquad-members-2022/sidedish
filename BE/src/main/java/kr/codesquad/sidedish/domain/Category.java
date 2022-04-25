package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Category {

    @Id
    private final Long categoryId;
    private final String categoryName;

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
