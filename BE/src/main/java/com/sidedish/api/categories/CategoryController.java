package com.sidedish.api.categories;

import com.sidedish.api.categories.dto.ItemResource;
import com.sidedish.api.categories.dto.ResponseItemDto;
import com.sidedish.api.categories.dto.ResponseItemList;
import com.sidedish.api.categories.dto.ResponseSingleItemDto;
import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;
import com.sidedish.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final ItemService itemService;

    @InitBinder
    private void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(CategoryType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(CategoryType.valueOf(text.toUpperCase()));
            }
        });
    }

    @GetMapping("/{type}/detail")
    public List<ResponseItemDto> getItemByDetailType(@PathVariable String type) {
        List<Item> findItems = itemService.findItemByDetailType(type);
        return findItems.stream()
                .map(ResponseItemDto::new)
                .limit(3)
                .collect(Collectors.toList());
    }

    @GetMapping("/{type}")
    public RepresentationModel<?> getItemsByCategory(@PathVariable CategoryType type, @RequestParam(defaultValue = "1") Long pageId, @RequestParam(defaultValue = "4") int pageCount) {
        List<Item> items = itemService.findUnitPageById(type, pageId, pageCount);
        List<ItemResource> itemResources = items.stream().map(ItemResource::new).collect(Collectors.toList());
        ResponseItemList responseItemList = new ResponseItemList(type, itemResources);
        RepresentationModel<?> responseMainType = RepresentationModel.of(responseItemList);
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type, pageId, pageCount)).withSelfRel());
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type, pageId -1, pageCount)).withRel("prev-page"));
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type, pageId +1, pageCount)).withRel("next-page"));
        return responseMainType;
    }

    @GetMapping("/items/{itemId}")
    public ResponseSingleItemDto getSingleItem(@PathVariable Long itemId, @RequestParam(defaultValue = "1") Long pageId, @RequestParam(defaultValue = "5") int pageCount) {
        Item findItem = itemService.findItemById(itemId);
        ItemResource itemResource = new ItemResource(findItem);

        List<Item> items = itemService.suggestAnotherTypeItems(itemId, pageId, pageCount);
        List<ItemResource> itemResources = items.stream().map(ItemResource::new).collect(Collectors.toList());
        CollectionModel<ItemResource> responseMainType = CollectionModel.of(itemResources);
        responseMainType.add(linkTo(methodOn(CategoryController.class).getSingleItem(itemId ,pageId, pageCount)).withSelfRel());
        responseMainType.add(linkTo(methodOn(CategoryController.class).getSingleItem(itemId,pageId-1, pageCount)).withRel("prev-page"));
        responseMainType.add(linkTo(methodOn(CategoryController.class).getSingleItem(itemId, pageId+1, pageCount)).withRel("next-page"));
        return new ResponseSingleItemDto(itemResource, responseMainType);
    }
}
