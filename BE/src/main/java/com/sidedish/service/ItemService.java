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

    private final ItemRepository itemRepository;

    public List<Item> findUnitPageById(Long typeNumber, Long pageId, int pageCount) {
        int startPage = pageId.intValue() - 1;
        PageRequest pageable = PageRequest.of(startPage, pageCount);
        return itemRepository.findByCategory(typeNumber, pageable);
    }

    public List<Item> findItemByDetailType(String type) {
        return itemRepository.findByDetailType(type);
    }
}
