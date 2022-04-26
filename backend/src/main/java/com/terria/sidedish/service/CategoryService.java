package com.terria.sidedish.service;

import com.terria.sidedish.domain.entity.aggregate.Category;
import com.terria.sidedish.domain.entity.aggregate.SideDish;
import com.terria.sidedish.domain.entity.link.CategoryHasSideDish;
import com.terria.sidedish.domain.entity.link.SideDishHasDiscountEvent;
import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import com.terria.sidedish.dto.response.CategoryResponse;
import com.terria.sidedish.dto.response.CategoryResponses;
import com.terria.sidedish.dto.response.SideDishCardResponse;
import com.terria.sidedish.repository.CategoryRepository;
import com.terria.sidedish.repository.DiscountEventRepository;
import com.terria.sidedish.repository.SideDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SideDishRepository sideDishRepository;
    private final DiscountEventRepository discountEventRepository;

    public CategoryResponses getAllByExhibitionId(long exhibitionId) {

        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for (Category category : categoryRepository.findByExhibitionId(exhibitionId)) {
            List<SideDishCardResponse> sideDishCardResponses = new ArrayList<>();

            for (SideDish sideDish : getSideDishes(category)) {
                sideDishCardResponses.add(SideDishCardResponse.from(sideDish, getDiscountEvent(sideDish)));
            }

            categoryResponses.add(CategoryResponse.from(category, sideDishCardResponses));
        }

        return new CategoryResponses(categoryResponses);

    }

    private List<SideDish> getSideDishes(Category category) {

        return category.getCategoryHasSideDishes().stream()
                .map(CategoryHasSideDish::getSideDishId)
                .map(sideDishRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<DiscountEvent> getDiscountEvent(SideDish sideDish) {

        return sideDish.getSideDishHasDiscountEvents().stream()
                .map(SideDishHasDiscountEvent::getDiscountEventId)
                .map(discountEventRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
