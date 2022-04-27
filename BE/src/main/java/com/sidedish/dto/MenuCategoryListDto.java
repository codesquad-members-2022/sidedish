package com.sidedish.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class MenuCategoryListDto {

    private List<MenuCategoryDto> menuCategories;

    public MenuCategoryListDto(List<MenuCategoryDto> menuCategories) {
        this.menuCategories = menuCategories;
    }
}
