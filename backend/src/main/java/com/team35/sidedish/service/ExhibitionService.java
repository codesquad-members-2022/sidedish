package com.team35.sidedish.service;

import com.team35.sidedish.domain.entity.aggregate.Exhibition;
import com.team35.sidedish.dto.response.exhibition.CategoryResponse;
import com.team35.sidedish.dto.response.exhibition.ExhibitionResponse;
import com.team35.sidedish.error.exception.ExhibitionException;
import com.team35.sidedish.repository.ExhibitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.team35.sidedish.error.ErrorCode.*;

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
