package com.sidedish.service;

import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;
import com.sidedish.repository.CategoryRepository;
import com.sidedish.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public List<Item> findUnitPageById(CategoryType type, Long pageId, int pageCount) {
        Long categoeyId = categoryRepository.findCategoeyId(type);
        int startPage = pageId.intValue() - 1;
        PageRequest pageable = PageRequest.of(startPage, pageCount);
        return itemRepository.findByCategory(categoeyId, pageable);
    }

    public List<Item> findItemByDetailType(String type) {
        return itemRepository.findByDetailType(type);
    }
}
