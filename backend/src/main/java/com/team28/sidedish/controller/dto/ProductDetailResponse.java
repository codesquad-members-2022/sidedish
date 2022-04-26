package com.team28.sidedish.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ProductDetailResponse from(ProductResponse product, List<ProductImageResponse> allImages, int stock) {
        return new ProductDetailResponse(product.getProductId(),
                product.getProductName(),
                product.getDescription(),
                getRepresentImages(allImages),
                getDetailsImage(allImages),
                product.getPrice(),
                product.getDiscountPrice(),
                stock,
                product.getDiscountName());
    }

    private static List<ProductImageResponse> getRepresentImages(List<ProductImageResponse> images) {
        return images.stream()
                .filter(ProductImageResponse::isRepresentYn)
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<ProductImageResponse> getDetailsImage(List<ProductImageResponse> images) {
        return images.stream()
                .filter(img -> !img.isRepresentYn())
                .collect(Collectors.toUnmodifiableList());
    }
}
