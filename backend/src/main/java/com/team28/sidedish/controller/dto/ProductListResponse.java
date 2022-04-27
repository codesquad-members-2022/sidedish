package com.team28.sidedish.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Schema(description = "상품 목록 조회 결과")
@Getter
@AllArgsConstructor
public class ProductListResponse {

    @Schema(description = "등록된 상품 수")
    private final int count;

    @Schema(description = "상품 리스트")
    private final List<ProductResponse> products;
}
