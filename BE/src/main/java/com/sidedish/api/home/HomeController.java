package com.sidedish.api.home;

import com.sidedish.api.categories.CategoryController;
import com.sidedish.api.categories.dto.ItemResource;
import com.sidedish.api.categories.dto.ResponseItemDto;
import com.sidedish.api.home.dto.ResponseHomeDto;
import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;
import com.sidedish.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/api/home")
@RequiredArgsConstructor
@RestController
public class HomeController {

    private final ItemService itemService;

    @GetMapping
    public ResponseHomeDto getHome() {
        List<Item> findItems = itemService.findItemByDetailType("풍성한고기반찬");
        List<ResponseItemDto> detailItems = buildDetailItems(findItems);
        CollectionModel<ItemResource> responseMainType = buildItems();
        return new ResponseHomeDto(detailItems, responseMainType);
    }

    private CollectionModel<ItemResource> buildItems() {
        List<Item> items = itemService.findUnitPageById(CategoryType.MAIN, 1L, 4);
        List<ItemResource> itemResources = items.stream().map(ItemResource::new).collect(Collectors.toList());
        CollectionModel<ItemResource> responseMainType = CollectionModel.of(itemResources);
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(CategoryType.MAIN, 1l, 4)).withSelfRel());
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(CategoryType.MAIN, 2l, 4)).withRel("next-page"));
        return responseMainType;
    }

    private List<ResponseItemDto> buildDetailItems(List<Item> findItems) {
        return findItems.stream()
                .map(ResponseItemDto::new)
                .limit(3)
                .collect(Collectors.toList());
    }
}
