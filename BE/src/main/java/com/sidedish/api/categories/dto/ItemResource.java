package com.sidedish.api.categories.dto;

import com.sidedish.api.categories.CategoryController;
import com.sidedish.domain.Item;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.Relation;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Relation(collectionRelation = "mains", itemRelation = "main")
public class ItemResource extends EntityModel<ResponseItemDto> {
    public ItemResource(Item content) {
        super(new ResponseItemDto(content));
        add(linkTo(methodOn(CategoryController.class).getSingleItem(content.getId())).withSelfRel());
    }
}
