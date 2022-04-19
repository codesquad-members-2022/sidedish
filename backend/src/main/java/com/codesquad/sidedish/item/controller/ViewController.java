package com.codesquad.sidedish.item.controller;

import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @GetMapping("/items")
    public CategoryItemsDto list() {
        return null;
    }

    @GetMapping("/items/{itemId}")
    public DetailItemDto detail(@PathVariable Integer itemId) {
        return null;
    }
}
