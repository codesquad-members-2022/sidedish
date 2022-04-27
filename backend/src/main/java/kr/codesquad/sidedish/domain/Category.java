package kr.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Category {

    @Id
    private Long id;
    private final String name;
    private final String description;

    @MappedCollection(idColumn = "category_id", keyColumn = "id")
    private final List<Subcategory> subcategories;
}
