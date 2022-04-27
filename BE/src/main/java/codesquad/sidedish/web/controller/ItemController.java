package codesquad.sidedish.web.controller;

import codesquad.sidedish.web.dto.ItemDetailResponse;
import codesquad.sidedish.web.dto.ItemListElement;
import codesquad.sidedish.web.dto.ItemListResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping("/{itemId}")
    public ItemDetailResponse itemDetail(@PathVariable Long itemId) {
        return new ItemDetailResponse();
    }

    @GetMapping
    public ItemListResponse loadItems(@RequestParam String section) {
        ItemListElement sampleElement = new ItemListElement();
        List<ItemListElement> items = List.of(sampleElement);
        return new ItemListResponse(items);
    }
}
