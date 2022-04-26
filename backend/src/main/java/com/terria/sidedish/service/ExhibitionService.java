package com.terria.sidedish.service;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import com.terria.sidedish.dto.response.ExhibitionResponse;
import com.terria.sidedish.error.ExhibitionException;
import com.terria.sidedish.repository.ExhibitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.terria.sidedish.error.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    public ExhibitionResponse getByExhibitionId(long exhibitionId) {
        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow(() -> new ExhibitionException(EXHIBITION_VALIDATION_ERROR));

        return ExhibitionResponse.from(exhibition);
    }
}
