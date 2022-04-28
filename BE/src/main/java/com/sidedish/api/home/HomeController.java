package com.sidedish.api.home;

import com.sidedish.api.categories.CategoryController;
import com.sidedish.api.categories.dto.ItemResource;
import com.sidedish.api.categories.dto.ResponseItemDto;
import com.sidedish.api.home.dto.ResponseHomeDto;
import com.sidedish.domain.CategoryType;
import com.sidedish.domain.DetailCategoryType;
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

    private static final long DEFAULT_PAGE_ID = 1L;
    private static final int DEFAULT_PAGE_COUNT = 4;
    private static final int DEFAULT_DETAIL_PAGE_COUNT = 3;
    private final ItemService itemService;

    @GetMapping
    public ResponseHomeDto getHome() {
        List<Item> findItems = itemService.findItemByDetailType(DetailCategoryType.MEAT.getDetailType());
        List<ResponseItemDto> detailItems = buildDetailItems(findItems);
        CollectionModel<ItemResource> mainResources = buildItems(CategoryType.MAIN, DEFAULT_PAGE_ID, DEFAULT_PAGE_COUNT);
        return new ResponseHomeDto(detailItems, mainResources);
    }

    @GetMapping("/additional")
    public ResponseAdditionalDto getAdditionalCategory(){
        CollectionModel<ItemResource> soupResources = buildItems(CategoryType.SOUP, DEFAULT_PAGE_ID, DEFAULT_PAGE_COUNT);
        CollectionModel<ItemResource> sideResources = buildItems(CategoryType.SIDE, DEFAULT_PAGE_ID, DEFAULT_PAGE_COUNT);
        return new ResponseAdditionalDto(soupResources, sideResources);
    }

    private CollectionModel<ItemResource> buildItems(CategoryType type, Long pageId, int pageCount) {
        List<Item> items = itemService.findUnitPageById(type, pageId, pageCount);
        List<ItemResource> itemResources = items.stream().map(ItemResource::new).collect(Collectors.toList());
        CollectionModel<ItemResource> responseMainType = CollectionModel.of(itemResources);
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type, pageId, pageCount)).withSelfRel());
        responseMainType.add(linkTo(methodOn(CategoryController.class).getItemsByCategory(type, pageId+1, pageCount)).withRel("next-page"));
        return responseMainType;
    }

    private List<ResponseItemDto> buildDetailItems(List<Item> findItems) {
        return findItems.stream()
                .map(ResponseItemDto::new)
                .limit(DEFAULT_DETAIL_PAGE_COUNT)
                .collect(Collectors.toList());
    }
}
