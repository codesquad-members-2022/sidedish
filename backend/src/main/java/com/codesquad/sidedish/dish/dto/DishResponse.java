package com.codesquad.sidedish.dish.dto;

import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
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
    private final String imagePath;

    private final List<DiscountResponse> discounts;

    public static DishResponse from(Dish dish) {

        return new DishResponse(
            dish.getId(),
            dish.getTitle(),
            dish.getDescription(),
            dish.getPrice(),
            dish.getStock(),
            ImageResponse.getFirstPath(dish.getImages()),
            DiscountResponse.from(dish.getDiscounts())
        );
    }

}
