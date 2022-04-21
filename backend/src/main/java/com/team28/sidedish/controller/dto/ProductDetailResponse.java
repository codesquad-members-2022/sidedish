package com.team28.sidedish.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "상품 상세조회 결과")
@Getter
@NoArgsConstructor
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
    private int price;

    @Schema(description = "할인된 가격")
    private int discountPrice;

    @Schema(description = "상품 재고")
    private int stockQuantity;

    @Schema(description = "할인 이름")
    private String eventInfo;

    public static ProductDetailResponse from(ProductResponse product, List<ProductImageResponse> allImages, int stock) {
        ProductDetailResponse detail = new ProductDetailResponse();
        detail.productId = product.getProductId();
        detail.productName = product.getProductName();
        detail.description = product.getDescription();
        detail.representImages = getRepresentImages(allImages);
        detail.detailImages = getDetailsImage(allImages);
        detail.price = product.getPrice();
        detail.discountPrice = product.getDiscountPrice();
        detail.stockQuantity = stock;
        detail.eventInfo = product.getDiscountName();

        return detail;
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
