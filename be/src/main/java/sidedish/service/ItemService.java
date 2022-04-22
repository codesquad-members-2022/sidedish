package sidedish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.images.Images;
import sidedish.domain.item.Item;
import sidedish.domain.item.ItemRepository;
import sidedish.web.dto.item.ResponseItemDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ResponseItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return mapItemToDto(item);
    }

    private ResponseItemDto mapItemToDto(Item item) {

        String mainImageUrl = item.getImages().stream()
                .filter(Images::isMainStatus)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getUrl();

        List<String> tabList = item.getImages().stream()
                .filter((i) -> !i.isMainStatus())
                .map(i -> i.getUrl())
                .collect(Collectors.toList());

        return new ResponseItemDto(item, mainImageUrl, tabList);
    }
}
