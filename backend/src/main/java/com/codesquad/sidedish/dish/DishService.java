package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.dto.DishResponse;
import com.codesquad.sidedish.dish.dto.Slice;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public Slice<DishResponse> findDishBySection(String sectionName) {
        List<Dish> dishes = dishRepository.findBySectionName(sectionName);

        List<DishResponse> responses = dishes.stream()
            .map(DishResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses);
    }

    public Slice<DishResponse> findDishByCategory(String categoryName) {
        List<Dish> dishes = dishRepository.findByCategoryName(categoryName);

        List<DishResponse> responses = dishes.stream()
            .map(DishResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses);
    }

}
