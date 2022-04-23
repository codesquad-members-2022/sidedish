package com.codesquad.sidedish.item.controller;

import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import com.codesquad.sidedish.item.exception.ItemIdNotFoundException;
import com.codesquad.sidedish.item.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/items")
@RestController
public class ItemController {
    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public CategoryItemsDto itemList() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailItemDto> detail(@PathVariable int id) {
        DetailItemDto detailItemDto;
        try {
            detailItemDto = itemService.findById(id);
        } catch (ItemIdNotFoundException e) {
            log.debug("ItemController: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailItemDto);
    }
}
