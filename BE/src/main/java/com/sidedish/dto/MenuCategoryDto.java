package com.sidedish.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class MenuCategoryDto {

    private final String menuCategoryName;
    private final List<SideDishDto> sideDishes;

    public MenuCategoryDto(String menuCategoryName,
        List<SideDishDto> sideDishes) {
        this.menuCategoryName = menuCategoryName;
        this.sideDishes = sideDishes;
    }
}
