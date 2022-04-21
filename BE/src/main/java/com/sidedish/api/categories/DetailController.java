package com.sidedish.api.categories;

import com.sidedish.api.categories.dto.ResponseItemDto;
import com.sidedish.domain.Item;
import com.sidedish.service.ItemService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class DetailController {

    private final ItemService itemService;

    @GetMapping("/detail")
    public List<ResponseItemDto> getItemByDetailType(@RequestParam String type) {
        log.info("type {}", type);
        List<Item> findItems = itemService.findItemByDetailType(type);
        log.info("findItems {}", findItems);
        return findItems.stream().map(ResponseItemDto::new).limit(3).collect(Collectors.toList());
    }
}
