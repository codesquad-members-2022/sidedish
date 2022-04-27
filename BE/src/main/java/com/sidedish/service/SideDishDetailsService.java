package com.sidedish.service;

import com.sidedish.domain.SideDish;
import com.sidedish.dto.SideDishDetailsDto;
import com.sidedish.dto.SideDishDto;
import com.sidedish.mapper.SideDishMapper;
import com.sidedish.repository.SideDishRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SideDishDetailsService {

    private final SideDishRepository sideDishRepository;

    private final Map<Integer, Integer> recommendCategoryIds = Map.of(1, 3, 2, 4, 3, 1, 4, 2);
    /**
     *   (자료구조 설명)
     *   조회된 반찬 정보의 menuCategoryId가 1일 경우 3의 menuCategoryId에 속하는 반찬 정보들을 추천해준다.
     *   조회된 반찬 정보의 menuCategoryId가 2일 경우 4의 menuCategoryId에 속하는 반찬 정보들을 추천해준다.
     */

    public SideDishDetailsDto getSideDishDetails(Integer id) {
        SideDish sideDish = sideDishRepository.findBySideDishId(id);
        Integer menuCategoryId = sideDish.getMenuCategoryId();
        Integer recommendedMenuCategoryId = recommendCategoryIds.get(menuCategoryId);

        List<SideDishDto> recommendedSideDishes = sideDishRepository.findAllByMenuCategoryId(recommendedMenuCategoryId)
            .stream()
            .limit(8)
            .map(SideDishMapper::convertToSideDishDto)
            .collect(Collectors.toList());

        return SideDishMapper.convertToSideDishDetailsDto(sideDish, recommendedSideDishes);
    }

}
