package com.sidedish.api.home.dto;

import com.sidedish.api.categories.dto.ItemResource;
import com.sidedish.api.categories.dto.ResponseItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHomeDto {
    private List<ResponseItemDto> detailItems;
    private CollectionModel<ItemResource> responseMainType;
}
