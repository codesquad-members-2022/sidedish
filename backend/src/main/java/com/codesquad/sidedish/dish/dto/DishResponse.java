package com.codesquad.sidedish.dish.dto;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.DishImage;
import com.codesquad.sidedish.event_badge.dto.EventBadgeResponse;
import java.util.List;
import java.util.stream.Collectors;
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

    private final List<EventBadgeResponse> eventBadges;
    // dish image
    private final String imagePath;

    public static DishResponse from(Dish dish) {
        List<EventBadgeResponse> eventBadges = dish.getEventBadges() != null ?
            dish.getEventBadges().stream()
                .map(EventBadgeResponse::from)
                .collect(Collectors.toList()) : null;
        DishImage dishImage = dish.getDishImage();

        return new DishResponse(
            dish.getId(),
            dish.getTitle(),
            dish.getDescription(),
            dish.getPrice(),
            dish.getStock(),
            eventBadges,
            dishImage != null ? dishImage.getImagePath() : null
        );
    }

}
