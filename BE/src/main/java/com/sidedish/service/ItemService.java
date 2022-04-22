package com.sidedish.service;

import com.sidedish.domain.Item;
import com.sidedish.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    public static final int PAGE_UNIT = 4;
    private final ItemRepository itemRepository;

    public List<Item> findUnitPageById(Long typeNumber, Long pageId) {
        int startPage = pageId.intValue() - 1;
        PageRequest pageable = PageRequest.of(startPage, PAGE_UNIT);
        return itemRepository.findByCategory(typeNumber, pageable);
    }

    public List<Item> findItemByDetailType(String type) {
        return itemRepository.findByDetailType(type);
    }
}
