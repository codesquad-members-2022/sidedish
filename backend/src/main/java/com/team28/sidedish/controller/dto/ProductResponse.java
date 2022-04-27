package com.team28.sidedish.controller.dto;

import com.team28.sidedish.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "상품 정보")
@Getter
@AllArgsConstructor
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
    private Long price;

    @Schema(description = "할인된 가격")
    private Long discountPrice;

    @Schema(description = "할인 이름")
    private String discountName;

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getRepresentImage(),
                product.getDescription(),
                product.getPrice(),
                product.getDiscountPrice(),
                product.getDiscountName()
        );
    }

}
