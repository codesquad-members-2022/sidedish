package com.terria.sidedish.service;

import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import com.terria.sidedish.domain.entity.link.CategoryHasSideDish;
import com.terria.sidedish.domain.entity.link.SideDishHasDiscountEvent;
import com.terria.sidedish.domain.entity.reference.Category;
import com.terria.sidedish.domain.entity.reference.SideDish;
import com.terria.sidedish.dto.response.CategoryResponse;
import com.terria.sidedish.dto.response.ExhibitionResponse;
import com.terria.sidedish.dto.response.SideDishCardResponse;
import com.terria.sidedish.error.ExhibitionException;
import com.terria.sidedish.repository.DiscountEventRepository;
import com.terria.sidedish.repository.ExhibitionRepository;
import com.terria.sidedish.repository.SideDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.terria.sidedish.error.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    private final SideDishRepository sideDishRepository;

    private final DiscountEventRepository discountEventRepository;

    public ExhibitionResponse getByExhibitionId(long exhibitionId) {
        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow(
                        () -> new ExhibitionException(EXHIBITION_VALIDATION_ERROR)
                );

        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for (Category category : exhibition.getCategories()) {
            List<SideDishCardResponse> sideDishCardResponses = new ArrayList<>();

            for (SideDish sideDish : getSideDishes(category)) {
                sideDishCardResponses.add(SideDishCardResponse.from(sideDish, getDiscountEvent(sideDish)));
            }

            categoryResponses.add(CategoryResponse.from(category, sideDishCardResponses));
        }

        return ExhibitionResponse.from(exhibition.getId(), exhibition.getTitle(), categoryResponses);
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
