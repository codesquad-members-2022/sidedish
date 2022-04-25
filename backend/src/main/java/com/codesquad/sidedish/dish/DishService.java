package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.dto.DishResponse;
import com.codesquad.sidedish.dish.dto.Slice;
import com.codesquad.sidedish.event_badge.EventBadgeRepository;
import com.codesquad.sidedish.event_badge.domain.EventBadge;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final EventBadgeRepository eventBadgeRepository;

    public Slice<DishResponse> findDishBySection(String sectionName) {
        List<Dish> dishes = dishRepository.findBySectionName(sectionName);
        List<EventBadge> eventBadges = eventBadgeRepository.findAll();
        DishUtil.mapEventBadges(dishes, eventBadges);

        List<DishResponse> responses = dishes.stream()
            .map(DishResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses);
    }

    public Slice<DishResponse> findDishByCategory(String categoryName) {
        List<Dish> dishes = dishRepository.findByCategoryName(categoryName);
        List<EventBadge> eventBadges = eventBadgeRepository.findAll();
        DishUtil.mapEventBadges(dishes, eventBadges);

        List<DishResponse> responses = dishes.stream()
            .map(DishResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses);
    }

}
