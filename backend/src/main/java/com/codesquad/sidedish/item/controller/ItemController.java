package com.codesquad.sidedish.item.controller;

import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import com.codesquad.sidedish.item.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public CategoryItemsDto list() {
        return itemService.findAll();
    }

    @GetMapping("/items/{id}")
    public DetailItemDto detail(@PathVariable Integer id) {
        return itemService.findById(id);
    }
}
