package com.codesquad.sidedish.item.service;

import com.codesquad.sidedish.item.domain.DiscountPolicyRepository;
import com.codesquad.sidedish.item.domain.Item;
import com.codesquad.sidedish.item.domain.ItemRepository;
import com.codesquad.sidedish.item.dto.CategoryItemsDto;
import com.codesquad.sidedish.item.dto.DetailItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private static final Logger log = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;
    private final DiscountPolicyRepository discountPolicyRepository;

    public ItemService(ItemRepository itemRepository, DiscountPolicyRepository discountPolicyRepository) {
        this.itemRepository = itemRepository;
        this.discountPolicyRepository = discountPolicyRepository;
    }

    public CategoryItemsDto findAll() {
        Map<Integer, List<Item>> itemMap = itemRepository.findAll().stream()
                .collect(Collectors.groupingBy(Item::getCategoryId));
        return null;
    }

    public DetailItemDto findById(Integer itemId) {
        return null;
    }
}
