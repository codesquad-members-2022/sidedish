package com.codesquad.sidedish.dish.dto;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.DishDelivery;
import com.codesquad.sidedish.dish.domain.DishDiscount;
import com.codesquad.sidedish.dish.domain.DishImage;
import com.codesquad.sidedish.other.DeliveryPolicy;
import com.codesquad.sidedish.other.DiscountPolicy;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DishUnitResponse {

    private final Integer dishId;
    private final String title;
    private final String description;
    private final Integer fixedPrice;
    private final Integer discountPrice;
    private final Integer stock;

    private final List<String> images;
    private final List<String> deliveries;
    private final List<String> discounts;

    public static DishUnitResponse from(Dish dish) {
        return new DishUnitResponse(
            dish.getId(),
            dish.getTitle(),
            dish.getDescription(),
            dish.getPrice(),
            dish.getDiscountPrice(),
            dish.getStock(),
            toImagePaths(dish.getImages()),
            toDeliveryDetails(dish.getDeliveries()),
            toDiscountDetails(dish.getDiscounts())
        );
    }

    public static List<String> toImagePaths(Set<DishImage> dishImage) {
        return dishImage.stream()
            .sorted(Comparator.comparingInt(DishImage::getSequence))
            .map(DishImage::getImagePath)
            .collect(Collectors.toList());
    }

    public static List<String> toDeliveryDetails(Set<DishDelivery> dishDeliveries) {
        return dishDeliveries.stream()
            .map(DishDelivery::getCode)
            .map(DeliveryPolicy::from)
            .map(DeliveryPolicy::getDetail)
            .collect(Collectors.toList());
    }

    public static List<String> toDiscountDetails(Set<DishDiscount> dishDiscounts) {
        return dishDiscounts.stream()
            .map(DishDiscount::getCode)
            .map(DiscountPolicy::from)
            .map(DiscountPolicy::getDetail)
            .collect(Collectors.toList());
    }

}
