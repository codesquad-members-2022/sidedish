package com.sidedish.service;

import com.sidedish.domain.SideDish;
import com.sidedish.dto.SideDishDto;
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
        List<SideDish> sideDishes = sideDishRepository.findAllByEventCategoryId(eventCategoryId);

        return new SideDishListDto(shuffleSideDishes(sideDishes));
    }

    private List<SideDishDto> shuffleSideDishes(List<SideDish> sideDishes) {
        Collections.shuffle(sideDishes);
        SideDishMapper mapper = new SideDishMapper();

        return sideDishes.stream()
            .limit(3)
            .map(mapper::convertToDto)
            .collect(Collectors.toList());
    }
}
