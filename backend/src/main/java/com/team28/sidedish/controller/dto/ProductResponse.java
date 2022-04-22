package com.team28.sidedish.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "상품 정보")
@Getter
@Builder
public class ProductResponse {

    @Schema(description = "상품 id")
    private Long productId;

    @Schema(description = "상품명")
    private String productName;

    @Schema(description = "대표 이미지 URL")
    private String imageURL;

    @Schema(description = "상품 설명")
    private String description;

    @Schema(description = "상품 가격")
    private int price;

    @Schema(description = "할인된 가격")
    private int discountPrice;

    @Schema(description = "할인 이름")
    private String discountName;

}
