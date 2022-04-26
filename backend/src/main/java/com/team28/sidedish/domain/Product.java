package com.team28.sidedish.domain;

import com.team28.sidedish.controller.dto.ProductImageResponse;
import com.team28.sidedish.repository.entity.DiscountEntity;
import com.team28.sidedish.repository.entity.ProductEntity;
import com.team28.sidedish.repository.entity.ProductImageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Product {

    private final static String EMPTY_IMAGE_URL = "";

    private final Long id;
    private final String name;
    private final String description;
    private final Long price;
    private final int stockQuantity;
    private final Long discountPrice;
    private final String discountName;

    private final List<ProductImageEntity> representImages;
    private final List<ProductImageEntity> detailImages;

    public static Product of(ProductEntity product, DiscountEntity discount) {
        return new Product(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                calculateDiscountPrice(product, discount),
                discount.getName(),
                getRepresentImages(product.getProductImages()),
                getDetailsImage(product.getProductImages())
        );
    }

    private static Long calculateDiscountPrice(ProductEntity product, DiscountEntity discount) {
        return (long) (product.getPrice() - (product.getPrice() * discount.getDiscountRate()));
    }

    private static List<ProductImageEntity> getRepresentImages(Set<ProductImageEntity> images) {
        return images.stream()
                .filter(ProductImageEntity::isRepresentYn)
                .sorted(Comparator.comparingInt(ProductImageEntity::getSequence))
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<ProductImageEntity> getDetailsImage(Set<ProductImageEntity> images) {
        return images.stream()
                .filter(img -> !img.isRepresentYn())
                .sorted(Comparator.comparingInt(ProductImageEntity::getSequence))
                .collect(Collectors.toUnmodifiableList());
    }

    public String getRepresentImage() {
        if (representImages.size() < 1) {
            return EMPTY_IMAGE_URL;
        }

        return representImages.get(0).getImagePath();
    }
}
