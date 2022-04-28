package codesquad.sidedish.service;

import codesquad.sidedish.domain.item.Item;
import codesquad.sidedish.domain.item.ItemRepository;
import codesquad.sidedish.exception.ItemNotFoundException;
import codesquad.sidedish.web.dto.ItemDetailResponse;
import codesquad.sidedish.web.dto.ItemListElement;
import codesquad.sidedish.web.dto.ItemListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemDetailResponse findOne(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException("해당하는 id의 상품이 없습니다.")
        );
        return new ItemDetailResponse(item);
    }

    public ItemListResponse findBySection(String itemSectionName) {
        List<ItemListElement> itemListElements = itemRepository.findByItemSectionName(itemSectionName)
                .stream()
                .map(ItemListElement::new)
                .collect(Collectors.toList());
        return new ItemListResponse(itemListElements);
    }


}
