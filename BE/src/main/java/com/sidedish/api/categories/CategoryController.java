package com.sidedish.api.categories;

import com.sidedish.api.categories.dto.ItemResource;
import com.sidedish.domain.Item;
import com.sidedish.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/main/{pageId}")
    public CollectionModel<ItemResource> getMain(@PathVariable Long pageId) {

        List<Item> items = itemService.findUnitPageById(pageId);
        List<ItemResource> itemResources = items.stream().map(ItemResource::new).collect(Collectors.toList());

        CollectionModel<ItemResource> responseMainType = CollectionModel.of(itemResources);
        responseMainType.add(linkTo(methodOn(CategoryController.class).getMain(pageId)).withSelfRel());
        responseMainType.add(linkTo(methodOn(CategoryController.class).getMain(pageId-1)).withRel("prev-page"));
        responseMainType.add(linkTo(methodOn(CategoryController.class).getMain(pageId+1)).withRel("next-page"));

        return responseMainType;
    }
}
