package com.sidedish.service;

import com.sidedish.domain.MenuCategory;
import com.sidedish.dto.MenuCategoryDto;
import com.sidedish.dto.MenuCategoryListDto;
import com.sidedish.dto.SideDishDto;
import com.sidedish.mapper.SideDishMapper;
import com.sidedish.repository.MenuCategoryRepository;
import com.sidedish.repository.SideDishRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final SideDishRepository sideDishRepository;

    public MenuCategoryListDto findFirstMenuCategoryWithSideDishes() {
        MenuCategory menuCategory = menuCategoryRepository.findFirstMenuCategory();

        String menuCategoryName = menuCategory.getName();
        List<SideDishDto> sideDishes = sideDishRepository.findAllByMenuCategoryId(menuCategory.getId())
            .stream()
            .map(SideDishMapper::convertToSideDishDto)
            .collect(Collectors.toList());

        MenuCategoryDto menuCategoryDto = new MenuCategoryDto(menuCategoryName, sideDishes);

        return new MenuCategoryListDto(List.of(menuCategoryDto));
    }

    public MenuCategoryListDto findRestOfCategoryWithSideDishes() {
        List<MenuCategoryDto> menuCategoryDtoList = new ArrayList<>();
        List<MenuCategory> menuCategories = menuCategoryRepository.findRestOfMenuCategories();

        for (MenuCategory menuCategory : menuCategories) {
            String menuCategoryName = menuCategory.getName();
            List<SideDishDto> sideDishes = sideDishRepository.findAllByMenuCategoryId(menuCategory.getId())
                .stream()
                .map(SideDishMapper::convertToSideDishDto)
                .collect(Collectors.toList());

            MenuCategoryDto menuCategoryDto = new MenuCategoryDto(menuCategoryName, sideDishes);
            menuCategoryDtoList.add(menuCategoryDto);
        }

        return new MenuCategoryListDto(menuCategoryDtoList);
    }
}
