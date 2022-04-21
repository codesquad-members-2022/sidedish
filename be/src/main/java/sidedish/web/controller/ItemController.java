package sidedish.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sidedish.service.ItemService;
import sidedish.web.dto.ResponseDto;
import sidedish.web.dto.item.ResponseItemDto;
import sidedish.web.dto.item.ResponseItemsDto;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
public class ItemController {

	private final ItemService service;

	@GetMapping
	private ResponseDto<ResponseItemsDto> getItems() {
		ResponseItemsDto items = service.findAllItems();
		return new ResponseDto<>(HttpStatus.OK, items);
	}

	@GetMapping("/{id}")
	private ResponseDto<ResponseItemDto> getItemDetail(@PathVariable Long id) {
		ResponseItemDto item = service.findItemById(id);
		return new ResponseDto<>(HttpStatus.OK, item);
	}
}
