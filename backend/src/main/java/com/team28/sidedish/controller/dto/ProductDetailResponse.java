package com.team28.sidedish.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ProductDetailResponse {

    private Long productId;
    private String productName;
    private String description;
    private List<ProductImageResponse> representImages;
    private List<ProductImageResponse> detailImages;
    private int price;
    private int discountPrice;
    private int stockQuantity;
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
