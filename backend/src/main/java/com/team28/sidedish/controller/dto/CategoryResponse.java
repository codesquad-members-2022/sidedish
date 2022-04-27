package com.team28.sidedish.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "카테고리 목록 조회 요청")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    @Schema(description = "카테고리 아이디")
    private Long categoryId;

    @Schema(description = "카테고리 이름")
    private String categoryName;

    public static CategoryResponse of(Long categoryId, String categoryName) {
        return new CategoryResponse(categoryId, categoryName);
    }
}
