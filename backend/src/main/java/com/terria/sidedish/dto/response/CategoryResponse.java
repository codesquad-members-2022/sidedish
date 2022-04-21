package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.entity.reference.Category;
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
    private List<SideDishCardResponse> sideDishCardResponses;

    public static CategoryResponse of(Category category, List<SideDishCardResponse> sideDishCardResponses) {
        return new CategoryResponse(category.getId(), category.getTitle(), sideDishCardResponses);
    }
}
