package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.*;
import team31.codesuqad.sidedish.controller.dto.EventTabListDto;
import team31.codesuqad.sidedish.controller.dto.CategoryResponse;
import team31.codesuqad.sidedish.type.EventType;
import team31.codesuqad.sidedish.service.EventService;

@RestController
@RequestMapping("/api/dish")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event-tabs")
    public EventTabListDto showEventTabs() {
        return eventService.findAll();
    }

    @GetMapping
    public CategoryResponse showEventTabDishes(@RequestParam("event-tabs") String eventType) {
        return eventService.getEventTab(EventType.valueOfOrNull(eventType));
    }

}
