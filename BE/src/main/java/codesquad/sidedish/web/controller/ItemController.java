package codesquad.sidedish.web.controller;

import codesquad.sidedish.exception.ErrorResult;
import codesquad.sidedish.service.ItemService;
import codesquad.sidedish.web.dto.ItemDetailResponse;
import codesquad.sidedish.web.dto.ItemListElement;
import codesquad.sidedish.web.dto.ItemListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDetailResponse> loadItemDetail(@PathVariable Long itemId) {
        return ResponseEntity.ok(itemService.findOne(itemId));
    }

    @GetMapping
    public ItemListResponse loadItems(@RequestParam String section) {
        return itemService.findBySection(section);
    }
}
