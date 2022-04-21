package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.repository.ItemRepository;

public class ItemService {

    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}
