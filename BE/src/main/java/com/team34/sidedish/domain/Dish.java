package com.team34.sidedish.domain;

import com.team34.sidedish.dto.DishDetailResponse;
import com.team34.sidedish.dto.DishResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Dish {

    private static int MAIN_IMAGE_INDEX = 0;

    @Id
    private Long id;
    private String title;
    private String content;
    private String tag;
    private int price;
    private int stock;
    private int deliveryFee;
    private Integer freeShippingAmount;
    private double mileageRate;
    private boolean earlyDeliverable;

    @MappedCollection(idColumn = "dish_id", keyColumn = "id")
    private List<CategoryDish> categories;

    @MappedCollection(idColumn = "dish_id", keyColumn = "id")
    private List<DishImage> images;

    public List<Long> categoryIds() {
        return categories.stream()
            .map(CategoryDish::getCategoryId)
            .collect(Collectors.toList());
    }

    public DishResponse toDishResponse() {
        return new DishResponse(
            id,
            price,
            calculateDiscountPrice(),
            earlyDeliverable,
            mainImagePath(),
            title,
            content,
            tag,
            categoryIds()
        );
    }

    public DishDetailResponse toDishDetailResponse(List<Dish> recommendedDishes) {
        return new DishDetailResponse(
            price,
            calculateDiscountPrice(),
            deliveryFee,
            mileageRate,
            earlyDeliverable,
            freeShippingAmount,
            title,
            content,
            getImagePaths(),
            tag,
            recommendedDishes.stream().map(Dish::toDishResponse).collect(Collectors.toList())
        );
    }

    private int calculateDiscountPrice() {
        Badge badge = Badge.of(tag);
        return badge.calculateDiscountPrice(price);
    }

    private String mainImagePath() {
        if (isImageExist()) {
            return images.get(MAIN_IMAGE_INDEX).getPath();
        }
        return "";
    }

    private boolean isImageExist() {
        return images.size() > 0;
    }

    private List<String> getImagePaths() {
        return images.stream()
            .map(DishImage::getPath)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Dish{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", price=" + price +
            ", stock=" + stock +
            ", deliveryFee=" + deliveryFee +
            ", freeShippingAmount=" + freeShippingAmount +
            ", mileageRate=" + mileageRate +
            ", earlyDeliverable=" + earlyDeliverable +
            ", categories=" + categories +
            ", images=" + images +
            '}';
    }
}
