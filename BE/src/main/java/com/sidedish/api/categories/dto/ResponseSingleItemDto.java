package com.sidedish.api.categories.dto;

import com.sidedish.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSingleItemDto {
    private Item item;
    private CollectionModel<ItemResource> suggestItemList;
}
