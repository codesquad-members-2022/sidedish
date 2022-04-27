package com.codesquad.sidedish.item.service;

import com.codesquad.sidedish.item.domain.Category;
import com.codesquad.sidedish.item.domain.CategoryRepository;
import com.codesquad.sidedish.item.domain.Item;
import com.codesquad.sidedish.item.dto.CategoryItemDto;
import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import com.codesquad.sidedish.item.dto.ItemDto;
import com.codesquad.sidedish.item.exception.CategoryIdNotFoundException;
import com.codesquad.sidedish.item.exception.ItemIdNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class ItemService {
    private final CategoryRepository categoryRepository;

    public ItemService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryItemsDto findAll() {
        List<CategoryItemDto> categoryItemDtoList = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();

        for (Category category : categories) {
            String categoryName = category.getName();
            Set<Item> items = category.getItems();

            List<ItemDto> itemDtoList = items.stream().map(ItemDto::from).collect(Collectors.toList());
            categoryItemDtoList.add(new CategoryItemDto(categoryName, itemDtoList));
        }
        return new CategoryItemsDto(categoryItemDtoList);
    }

    public DetailItemDto findById(int id) {
        Category category = categoryRepository.findByItemId(id)
                .orElseThrow(() -> new CategoryIdNotFoundException("존재하지 않는 카테고리입니다."));

        return category.getItems()
                .stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .map(item -> new DetailItemDto(item.getId(), item.getDiscountPolicy(), item.getDiscountRate(), item.getDescription(), item.getName(), item.getPrice(), item.calculatePoint(), item.getMainImageLink(), item.getItemImages()))
                .orElseThrow(() -> new ItemIdNotFoundException("존재하지 않는 아이템입니다."));
    }

    public CategoryItemDto findByCategory(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryIdNotFoundException("존재하지 않는 카테고리입니다."));
        Set<Item> items = category.getItems();
        return new CategoryItemDto(category.getName(), items.stream().map(ItemDto::from).collect(Collectors.toList()));
    }
}
