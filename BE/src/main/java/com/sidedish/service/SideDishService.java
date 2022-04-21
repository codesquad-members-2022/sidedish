package com.sidedish.service;

import com.sidedish.dto.SideDishListDto;
import com.sidedish.mapper.SideDishMapper;
import com.sidedish.repository.SideDishRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SideDishService {

    private final SideDishRepository sideDishRepository;

    public SideDishListDto getSideDishList(Integer eventCategoryId) {
        SideDishMapper mapper = new SideDishMapper();
        return new SideDishListDto(
            sideDishRepository.findAllByEventCategoryId(eventCategoryId)
            .stream()
            .map(mapper::convertToDto)
            .collect(Collectors.toList())
        );
    }
}
