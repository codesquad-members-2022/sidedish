package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.ItemService;
import kr.codesquad.sidedish.web.dto.item.ItemDetailResponseDto;
import kr.codesquad.sidedish.web.dto.item.ItemListResponseDto;
import kr.codesquad.sidedish.web.dto.item.ItemResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> findItemByCategoryId(@RequestParam Long categoryId){
        return ResponseEntity.ok(itemService.findItemByCategoryId(categoryId));
    }

    @GetMapping("/event")
    public List<ItemListResponseDto> getItemByBestId (@RequestParam int bestId) {
        return itemService.findByBestId(bestId);
    }

    @GetMapping("/detail/{id}")
    public ItemDetailResponseDto getItemDetailById (@PathVariable Long id) {
        return itemService.getItemDetailById(id);
    }
}
