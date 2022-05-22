package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "카테고리 정보")
@Getter
@NoArgsConstructor
public class CategoryResponse {

    @Schema(description = "카테고리 아이디")
    private Long id;
    @Schema(description = "카테고리 이름")
    private String name;
    @Schema(description = "해당 카테고리 상품 갯수")
    private int count;

    public static CategoryResponse from(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.id = category.getId();
        categoryResponse.name = category.getName();
        categoryResponse.count = category.getProductCount();
        return categoryResponse;
    }
}
