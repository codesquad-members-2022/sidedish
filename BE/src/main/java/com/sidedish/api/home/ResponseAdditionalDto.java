package com.sidedish.api.home;

import com.sidedish.api.categories.dto.ItemResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAdditionalDto {
    private CollectionModel<ItemResource> soupResources;
    private CollectionModel<ItemResource> sideResources;
}
