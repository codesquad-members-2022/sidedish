package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.entity.reference.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class CategoryResponse {

    @ApiModelProperty(required = true, value = "카테고리 아이디")
    private long categoryId;

    @ApiModelProperty(required = true, value = "카테고리 타이틀")
    private String categoryTitle;

    @ApiModelProperty("반찬 카드 목록")
    private List<SideDishCardResponse> sideDishCardResponses;

    public static CategoryResponse from(Category category, List<SideDishCardResponse> sideDishCardResponses) {
        return new CategoryResponse(category.getId(), category.getTitle(), sideDishCardResponses);
    }
}
