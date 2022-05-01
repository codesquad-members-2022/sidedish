package com.sidedish.mapper;

import com.sidedish.domain.SideDish;
import com.sidedish.dto.SideDishDetailsDto;
import com.sidedish.dto.SideDishDto;
import java.util.List;

public class SideDishMapper {

    public static SideDishDto convertToSideDishDto(SideDish sideDish) {
        return new SideDishDto(sideDish.getId(), sideDish.getName(),
            sideDish.getDescription(), sideDish.isDawnDeliveryFlag(),
            sideDish.isWholeNationDeliveryFlag(),
            sideDish.getPrice(), sideDish.getDiscountType(),
            sideDish.getDiscountRate(), sideDish.getMainImage());
    }

    public static SideDishDetailsDto convertToSideDishDetailsDto(SideDish sideDish, List<SideDishDto> recommendedSideDishes) {
        return new SideDishDetailsDto(sideDish.getId(), sideDish.getName(),
            sideDish.isDawnDeliveryFlag(), sideDish.isWholeNationDeliveryFlag(),
            sideDish.getPrice(), sideDish.getDiscountType(), sideDish.getDiscountRate(),
            sideDish.getSaveFileNames(), recommendedSideDishes);
    }

}
