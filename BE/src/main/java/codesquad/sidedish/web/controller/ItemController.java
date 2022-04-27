package codesquad.sidedish.web.controller;

import codesquad.sidedish.service.ItemService;
import codesquad.sidedish.web.dto.ItemDetailResponse;
import codesquad.sidedish.web.dto.ItemListElement;
import codesquad.sidedish.web.dto.ItemListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    public ItemDetailResponse loadItemDetail(@PathVariable Long itemId) {
        return itemService.findOne(itemId);
    }

    @GetMapping
    public ItemListResponse loadItems(@RequestParam String section) {
        return itemService.findBySection(section);
    }
}
