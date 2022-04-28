package sidedish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.category.EventCategory;
import sidedish.domain.category.EventRepository;
import sidedish.domain.item.Item;
import sidedish.domain.item.ItemRepository;
import sidedish.web.dto.DtoMapper;
import sidedish.web.dto.item.ResponseItemDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ItemRepository itemRepository;
    private final DtoMapper mapper;

    public List<EventCategory> findEventAll() {
        return eventRepository.findAll();
    }

    public List<ResponseItemDto> findEventItems(Long eventId) {
        List<Item> items = itemRepository.findItemsByEventId(eventId);
        return items.stream()
                .map(mapper::mapItemDomainToDto)
                .collect(Collectors.toList());
    }
}
