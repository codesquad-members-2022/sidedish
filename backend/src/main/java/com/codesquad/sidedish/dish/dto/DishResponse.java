package com.codesquad.sidedish.dish.dto;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.DishImage;
import com.codesquad.sidedish.other.domain.EventBadge;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DishResponse {

    private final Integer dishId;
    private final String title;
    private final String description;
    private final Integer price;
    private final Integer stock;

    // event badge
    private final String eventBadgeName;
    private final Float discount;

    // dish image
    private final String imagePath;

    public static DishResponse from(Dish dish) {
        EventBadge eventBadge = dish.getEventBadge();
        DishImage dishImage = dish.getDishImage();

        return new DishResponse(
            dish.getId(),
            dish.getTitle(),
            dish.getDescription(),
            dish.getPrice(),
            dish.getStock(),
            eventBadge != null ? eventBadge.getEventBadgeName() : null,
            eventBadge != null ? eventBadge.getDiscount() : null,
            dishImage != null ? dishImage.getImagePath() : null
        );
    }

}
