package com.sidedish.api.categories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSingleItemDto {
    private ItemResource item;
    private CollectionModel<ItemResource> suggestItemList;
}
