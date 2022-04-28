package com.sidedish.controller;

import com.sidedish.domain.SideDish;
import com.sidedish.dto.SideDishDetailsDto;
import com.sidedish.dto.SideDishDto;
import com.sidedish.dto.SideDishListDto;
import com.sidedish.service.EventCategoryService;
import com.sidedish.service.SideDishService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SideDishController {

    private final SideDishService sideDishService;

    @GetMapping("event-categories/{eventCategoryId}/sidedishes")
    public SideDishListDto getSideDishes(@PathVariable Integer eventCategoryId) {
        List<SideDish> sideDishes = sideDishService.getSideDishList(eventCategoryId);
        List<SideDishDto> sideDishDtoList = sideDishService.shuffleSideDishes(sideDishes);

        return new SideDishListDto(sideDishDtoList);
    }

    @GetMapping("sidedishes/{id}")
    public SideDishDetailsDto getSideDishDetails(@PathVariable Integer id) {
        return sideDishService.getSideDishDetails(id);
    }
}
