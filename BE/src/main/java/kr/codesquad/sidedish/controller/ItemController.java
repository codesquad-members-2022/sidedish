package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.ItemService;
import kr.codesquad.sidedish.web.dto.item.ItemDetailResponseDto;
import kr.codesquad.sidedish.service.OrderService;
import kr.codesquad.sidedish.web.dto.item.ItemListResponseDto;
import kr.codesquad.sidedish.web.dto.item.ItemResponseDto;
import kr.codesquad.sidedish.web.dto.order.OrderRequest;
import kr.codesquad.sidedish.web.dto.order.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;
    private final OrderService orderService;

    public ItemController(ItemService itemService, OrderService orderService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> findItemByCategoryId(@RequestParam Long categoryId) {
        return ResponseEntity.ok(itemService.findItemByCategoryId(categoryId));
    }

    @GetMapping("/event")
    public List<ItemListResponseDto> getItemByBestId(@RequestParam int bestId) {
        return itemService.findByBestId(bestId);
    }

    @GetMapping("/detail/{id}")
    public ItemDetailResponseDto getItemDetailById(@PathVariable Long id) {
        return itemService.getItemDetailById(id);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody OrderRequest orderRequest) {
        OrderResponse created = orderService.create(orderRequest);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
