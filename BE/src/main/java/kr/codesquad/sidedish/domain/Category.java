package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Category {

    @Id
    private final Long category_id;
    private final String category_name;

    public Category(Long category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }
}
