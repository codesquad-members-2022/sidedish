package kr.codesquad.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Category {

    @Id
    private Long id;
    private String name;
    private String description;

    @MappedCollection(idColumn = "category_id")
    private final Set<Subcategory> subcategories = new HashSet<>();
}
