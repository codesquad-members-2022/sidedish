package com.team35.sidedish.service;

import com.team35.sidedish.domain.entity.aggregate.SideDish;
import com.team35.sidedish.domain.entity.link.SideDishHasDiscountEvent;
import com.team35.sidedish.domain.entity.reference.DiscountEvent;
import com.team35.sidedish.dto.response.sidedish.SideDishCardResponse;
import com.team35.sidedish.dto.response.sidedish.SideDishCardResponses;
import com.team35.sidedish.dto.response.sidedish.SideDishDetailResponse;
import com.team35.sidedish.error.exception.SideDishException;
import com.team35.sidedish.repository.DiscountEventRepository;
import com.team35.sidedish.repository.SideDishRepository;
import com.team35.sidedish.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SideDishService {

    private final static int ITEM_COUNT = 4;

    private final SideDishRepository sideDishRepository;

    private final DiscountEventRepository discountEventRepository;

    @Transactional(readOnly = true)
    public SideDishCardResponses getByCategoryId(long categoryId, int page) {
        List<SideDishCardResponse> sideDishCardResponses = new ArrayList<>();

        List<SideDish> sideDishes = sideDishRepository.findByCategoryId(categoryId, page * ITEM_COUNT, ITEM_COUNT);

        for (SideDish sideDish : sideDishes) {
            sideDishCardResponses.add(SideDishCardResponse.from(sideDish, getDiscountEvent(sideDish)));
        }

        return new SideDishCardResponses(sideDishRepository.countByCategoryId(categoryId), sideDishCardResponses);
    }

    public SideDishDetailResponse getById(long id) {
        SideDish sideDish = sideDishRepository.findById(id)
                .orElseThrow(() -> new SideDishException(ErrorCode.NO_SUCH_SIDE_DISH_ERROR));

        return SideDishDetailResponse.from(sideDish, getDiscountEvent(sideDish));
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
