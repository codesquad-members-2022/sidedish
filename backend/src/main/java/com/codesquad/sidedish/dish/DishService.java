package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public List<Dish> findDishBySection(String slugName) {
        String sectionName = slugName.replace("-", " ");
        return dishRepository.findBySectionName(sectionName);
    }

    public List<Dish> findDishByCategory(String slugName) {
        String categoryName = slugName.replace("-", " ");
        return dishRepository.findByCategoryName(categoryName);
    }

}
