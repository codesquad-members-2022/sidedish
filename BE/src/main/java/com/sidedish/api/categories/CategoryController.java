package com.sidedish.api.categories;

import com.sidedish.domain.Item;
import com.sidedish.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{pageId}")
    public CollectionModel<Item> getMain(@PathVariable Long pageId) {
        List<Item> items = categoryService.findItemsByPageId(pageId);
        CollectionModel<Item> model = CollectionModel.of(items);
        model.add(linkTo(CategoryController.class).slash(pageId).withSelfRel());
        model.add(linkTo(CategoryController.class).slash(pageId-1).withRel("prev-page"));
        model.add(linkTo(CategoryController.class).slash(pageId+1).withRel("next-page"));
        return model;
    }
}
