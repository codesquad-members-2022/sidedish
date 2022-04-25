package com.sidedish.api.categories;

import com.sidedish.api.categories.dto.ItemResource;
import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;
import com.sidedish.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
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

    @GetMapping("/{type}")
    public CollectionModel<ItemResource> getItemsByCategory(@PathVariable CategoryType type, @RequestParam Long pageId) {

        List<Item> items = itemService.findUnitPageById(type.getTypeNumber(), pageId);
        List<ItemResource> itemResources = items.stream().map(ItemResource::new).collect(Collectors.toList());

        CollectionModel<ItemResource> responseMainType = CollectionModel.of(itemResources);
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type, pageId)).withSelfRel());
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type,pageId-1)).withRel("prev-page"));
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type, pageId+1)).withRel("next-page"));

        return responseMainType;
    }
}
