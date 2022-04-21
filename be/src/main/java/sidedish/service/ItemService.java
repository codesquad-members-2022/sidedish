package sidedish.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.item.Item;
import sidedish.domain.item.ItemRepository;
import sidedish.web.dto.ResponseDto;
import sidedish.web.dto.item.ResponseItemDto;
import sidedish.web.dto.item.ResponseItemsDto;

@RequiredArgsConstructor
@Service
public class ItemService {

	private final ItemRepository repository;

	public ResponseItemsDto findAllItems() {
		List<ResponseItemDto> list = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(e -> list.add(new ResponseItemDto(e)));
		return new ResponseItemsDto(list);
	}

	public ResponseItemDto findItemById(Long id) {
		Item item = repository.findById(id).orElseThrow(IllegalArgumentException::new);
		return new ResponseItemDto(item);
	}
}
