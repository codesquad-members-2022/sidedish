package team31.codesuqad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("categories")
public class Category {

    @Id
    private Integer id;
    private final String name;

    public Category(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
