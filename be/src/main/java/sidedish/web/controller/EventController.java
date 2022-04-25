package sidedish.web.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sidedish.domain.category.EventCategory;
import sidedish.domain.item.Item;
import sidedish.service.EventService;
import sidedish.web.dto.ResponseDto;
import sidedish.web.dto.item.ResponseItemDto;

@RequestMapping("/events")
@RequiredArgsConstructor
@RestController
public class EventController {

	private final EventService service;

	@GetMapping
	public ResponseDto<List<EventCategory>> getEventList() {
		return new ResponseDto<>(HttpStatus.OK, service.findEventAll());
	}

	@GetMapping("/{eventId}/items")
	public ResponseDto<List<ResponseItemDto>> getEventItems(@PathVariable Long eventId) {
		return new ResponseDto<>(HttpStatus.OK, service.findEventItems(eventId));
	}
}
