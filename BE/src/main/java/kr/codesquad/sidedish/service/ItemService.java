package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Item;
import kr.codesquad.sidedish.repository.ItemRepository;
import kr.codesquad.sidedish.web.dto.item.ItemDetailResponseDto;
import kr.codesquad.sidedish.web.dto.item.ItemListResponseDto;
import kr.codesquad.sidedish.web.dto.item.ItemResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponseDto> findItemByCategoryId(Long categoryId) {
        return itemRepository.findItemByCategoryId(categoryId)
                .stream().map(ItemResponseDto::of)
                .collect(Collectors.toList());
    }

    public List<ItemListResponseDto> findByBestId (int bestId) {
        return itemRepository.findByBestId(bestId)
                .stream().map(ItemListResponseDto::of)
                .collect(Collectors.toList());
    }

    public ItemDetailResponseDto getItemDetailById (Long id) {
        Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        return ItemDetailResponseDto.of(item);
    }

}
