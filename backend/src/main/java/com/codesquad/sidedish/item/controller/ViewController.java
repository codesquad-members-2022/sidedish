package com.codesquad.sidedish.item.controller;

import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import com.codesquad.sidedish.item.service.ViewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    private final ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping("/items")
    public CategoryItemsDto list() {
        return viewService.findAll();
    }

    @GetMapping("/items/{itemId}")
    public DetailItemDto detail(@PathVariable Integer itemId) {
        return viewService.findById(itemId);
    }
}
