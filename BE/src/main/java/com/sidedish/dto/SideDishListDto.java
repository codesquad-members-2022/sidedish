package com.sidedish.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class SideDishListDto {

    private List<SideDishDto> sideDishes;

    public SideDishListDto(List<SideDishDto> sideDishes) {
        this.sideDishes = sideDishes;
    }
}
