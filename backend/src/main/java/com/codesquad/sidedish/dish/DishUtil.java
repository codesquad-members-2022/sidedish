package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.event_badge.domain.DishRef;
import com.codesquad.sidedish.event_badge.domain.EventBadge;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DishUtil {

    public static void mapEventBadges(List<Dish> dishes, List<EventBadge> eventBadges) {
        Map<Integer, EventBadge> eventBadgeMap = eventBadges.stream()
            .collect(Collectors.toMap(EventBadge::getId, Function.identity()));

        Map<Integer, List<DishRef>> dishRefsMap = eventBadges.stream()
            .map(EventBadge::getDishRef)
            .flatMap(Set::stream)
            .collect(Collectors.groupingBy(DishRef::getDishId));

        for (Dish dish : dishes) {
            List<DishRef> dishRefs = dishRefsMap.getOrDefault(dish.getId(), List.of());

            List<EventBadge> dishEventBadges = dishRefs.stream()
                .map(DishRef::getEventBadgeId)
                .map(eventBadgeMap::get)
                .collect(Collectors.toList());
            dish.setEventBadges(dishEventBadges);
        }
    }
}
