package com.codesquad.sidedish.util;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.event_badge.domain.DishEventBadge;
import com.codesquad.sidedish.event_badge.domain.EventBadge;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperUtil {

    public static void mapEventBadges(List<Dish> dishes, List<EventBadge> eventBadges) {
        Map<Integer, EventBadge> eventBadgeMap = eventBadges.stream()
            .collect(Collectors.toMap(EventBadge::getId, Function.identity()));

        Map<Integer, List<DishEventBadge>> dishMap = eventBadges.stream()
            .map(EventBadge::getDishEventBadges)
            .flatMap(List::stream)
            .collect(Collectors.groupingBy(DishEventBadge::getDishId));

        for (Dish dish : dishes) {
            List<DishEventBadge> dishEventBadges = dishMap.get(dish.getId());

            if (dishEventBadges != null) {
                List<EventBadge> findEventBadges = dishMap.get(dish.getId()).stream()
                    .map(DishEventBadge::getEventBadgeId)
                    .map(eventBadgeMap::get)
                    .collect(Collectors.toList());
                dish.setEventBadges(findEventBadges);
            }
        }
    }
}
