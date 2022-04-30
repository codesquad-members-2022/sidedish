package com.team35.sidedish.dto.response.exhibition;

import com.team35.sidedish.domain.entity.aggregate.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryResponse {

    @ApiModelProperty(required = true, value = "카테고리 아이디")
    private long categoryId;

    @ApiModelProperty(required = true, value = "카테고리 타이틀")
    private String categoryTitle;

    public static CategoryResponse from(Category category) {
        return new CategoryResponse(category.getId(), category.getTitle());
    }
}
