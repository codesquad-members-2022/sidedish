package com.codesquad.sidedish.dish.dto;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.DishDiscount;
import com.codesquad.sidedish.dish.domain.DishImage;
import com.codesquad.sidedish.other.DiscountPolicy;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DishListResponse {

    private final Integer dishId;

    private final String title;
    private final String description;
    private final Integer fixedPrice;
    private final Integer discountPrice;
    private final Integer stock;
    private final String imagePath;

    private final List<String> discounts;

    public static DishListResponse from(Dish dish) {
        return new DishListResponse(
            dish.getId(),
            dish.getTitle(),
            dish.getDescription(),
            dish.getPrice(),
            dish.getDiscountPrice(),
            dish.getStock(),
            toImagePath(dish.getImages()),
            toDiscountDetails(dish.getDiscounts())
        );
    }

    public static String toImagePath(Set<DishImage> dishImage) {
        return dishImage.stream()
            .filter(image -> image.getSequence().equals(1))
            .map(DishImage::getImagePath)
            .findAny()
            .orElse("");
    }

    public static List<String> toDiscountDetails(Set<DishDiscount> dishDiscounts) {
        return dishDiscounts.stream()
            .map(DishDiscount::getCode)
            .map(DiscountPolicy::from)
            .map(DiscountPolicy::getDetail)
            .collect(Collectors.toList());
    }

}
