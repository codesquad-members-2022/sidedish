package com.sidedish.controller;

import com.sidedish.dto.SideDishDetailsDto;
import com.sidedish.service.SideDishDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SideDishDetailsController {

    private final SideDishDetailsService sideDishDetailsService;

    @GetMapping("sidedishes/{id}")
    public SideDishDetailsDto getSideDishDetails(@PathVariable Integer id) {
        return sideDishDetailsService.getSideDishDetails(id);
    }
}
