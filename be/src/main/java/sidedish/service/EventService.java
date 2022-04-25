package sidedish.service;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.category.EventCategory;
import sidedish.domain.category.EventRepository;
import sidedish.domain.item.Item;
import sidedish.web.dto.DtoMapper;
import sidedish.web.dto.item.ResponseItemDto;

@RequiredArgsConstructor
@Service
public class EventService {

	private final EventRepository repository;

	private final DtoMapper mapper;

	public List<EventCategory> findEventAll() {
		return Lists.newArrayList(repository.findAll());
	}

	public List<ResponseItemDto> findEventItems(Long eventId) {
		List<Item> items = repository.findItemsByEventId(eventId);
		return items.stream().map(mapper::mapItemDomainToDto)
			.collect(Collectors.toList());
	}
}
