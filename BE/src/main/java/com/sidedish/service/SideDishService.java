package com.sidedish.service;

import com.sidedish.domain.SideDish;
import com.sidedish.dto.SideDishListDto;
import com.sidedish.mapper.SideDishMapper;
import com.sidedish.repository.SideDishRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SideDishService {

    private final SideDishRepository sideDishRepository;

    public SideDishListDto getSideDishList(Integer eventCategoryId) {
        SideDishMapper mapper = new SideDishMapper();
        List<SideDish> sideDishes = sideDishRepository.findAllByEventCategoryId(eventCategoryId);
        Collections.shuffle(sideDishes);

        return new SideDishListDto(sideDishes.stream()
            .limit(3)
            .map(mapper::convertToDto)
            .collect(Collectors.toList()));
    }
}
