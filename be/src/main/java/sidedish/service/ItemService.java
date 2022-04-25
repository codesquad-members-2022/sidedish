package sidedish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.item.Item;
import sidedish.domain.item.ItemRepository;
import sidedish.web.dto.DtoMapper;
import sidedish.web.dto.item.ResponseItemDto;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final DtoMapper mapper;

    public ResponseItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return mapper.mapItemDomainToDto(item);

    }
}
