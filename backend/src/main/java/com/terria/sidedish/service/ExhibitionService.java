package com.terria.sidedish.service;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import com.terria.sidedish.dto.response.exhibition.CategoryResponse;
import com.terria.sidedish.dto.response.exhibition.ExhibitionResponse;
import com.terria.sidedish.error.ExhibitionException;
import com.terria.sidedish.repository.ExhibitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.terria.sidedish.error.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    public ExhibitionResponse getByExhibitionId(long exhibitionId) {
        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow(() -> new ExhibitionException(EXHIBITION_VALIDATION_ERROR));

        List<CategoryResponse> categoryResponses = exhibition.getCategories()
                .stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toList());

        return ExhibitionResponse.from(exhibition, categoryResponses);
    }
}
