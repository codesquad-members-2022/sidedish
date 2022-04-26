package com.team28.sidedish.controller.dto;

import com.team28.sidedish.domain.Product;
import com.team28.sidedish.repository.entity.ProductImageEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "상품 상세조회 결과")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponse {

    @Schema(description = "상품 id")
    private Long productId;

    @Schema(description = "상품명")
    private String productName;

    @Schema(description = "상품 설명")
    private String description;

    @Schema(description = "대표 이미지")
    private List<ProductImageResponse> representImages;

    @Schema(description = "상세설명 이미지")
    private List<ProductImageResponse> detailImages;

    @Schema(description = "상품 가격")
    private Long price;

    @Schema(description = "할인된 가격")
    private Long discountPrice;

    @Schema(description = "상품 재고")
    private int stockQuantity;

    @Schema(description = "할인 이름")
    private String eventInfo;

    public static ProductDetailResponse from(Product product) {
        return new ProductDetailResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                convertToProductImageResponses(product.getRepresentImages()),
                convertToProductImageResponses(product.getDetailImages()),
                product.getPrice(),
                product.getDiscountPrice(),
                product.getStockQuantity(),
                product.getDiscountName()
        );
    }

    private static List<ProductImageResponse> convertToProductImageResponses(List<ProductImageEntity> images) {
        return images.stream()
                .map(ProductImageResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
