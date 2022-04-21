package com.codesquad.sidedish.item.service;

import com.codesquad.sidedish.item.domain.Category;
import com.codesquad.sidedish.item.domain.CategoryRepository;
import com.codesquad.sidedish.item.domain.Item;
import com.codesquad.sidedish.item.domain.ItemRepository;
import com.codesquad.sidedish.item.dto.CategoryItemDto;
import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import com.codesquad.sidedish.item.dto.ItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private static final Logger log = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public CategoryItemsDto findAll() {
        List<CategoryItemDto> categoryItemDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();

        for (Category category : categoryList) {
            String categoryName = category.getName();
            Set<Item> items = category.getItems();

            List<ItemDto> itemDtoList = items.stream().map(ItemDto::from).collect(Collectors.toList());
            categoryItemDtoList.add(new CategoryItemDto(categoryName, itemDtoList));
        }
        return new CategoryItemsDto(categoryItemDtoList);
    }

    public DetailItemDto findById(Integer id) {
        return null;
    }
}
