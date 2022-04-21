package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class MainCategory {

    @Id
    private final Long id;
    private final String name;
    private final String description;

    public MainCategory(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
