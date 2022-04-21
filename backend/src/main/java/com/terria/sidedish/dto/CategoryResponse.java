package com.terria.sidedish.dto;

import com.terria.sidedish.domain.entity.reference.Category;
import com.terria.sidedish.domain.entity.reference.SideDish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponse {

    private long categoryId;
    private String categoryTitle;
    private List<SideDish> sideDishes;

    public static CategoryResponse of(Category category, List<SideDish> sideDishes) {
        return new CategoryResponse(category.getId(), category.getTitle(), sideDishes);
    }
}
