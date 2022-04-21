package com.terria.sidedish.service;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import com.terria.sidedish.domain.entity.link.CategoryHasSideDish;
import com.terria.sidedish.domain.entity.reference.Category;
import com.terria.sidedish.domain.entity.reference.SideDish;
import com.terria.sidedish.dto.CategoryResponse;
import com.terria.sidedish.dto.ExhibitionResponse;
import com.terria.sidedish.repository.ExhibitionRepository;
import com.terria.sidedish.repository.SideDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    private final SideDishRepository sideDishRepository;

    public ExhibitionResponse getByExhibitionId(long exhibitionId) {
        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow();

        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for (Category category : exhibition.getCategories()) {

            List<SideDish> sideDishes = category.getCategoryHasSideDishes().stream()
                    .map(CategoryHasSideDish::getSideDishId)
                    .map(sideDishRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            categoryResponses.add(CategoryResponse.of(category, sideDishes));
        }

        return ExhibitionResponse.of(exhibition.getId(), exhibition.getTitle(), categoryResponses);
    }
}
