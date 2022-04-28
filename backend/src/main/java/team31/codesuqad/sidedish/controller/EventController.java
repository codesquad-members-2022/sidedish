package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team31.codesuqad.sidedish.controller.dto.CategoryResponse;
import team31.codesuqad.sidedish.domain.Event;
import team31.codesuqad.sidedish.service.EventService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/api/dish")
    public CategoryResponse showEventTab(@RequestParam("event-tabs") String eventTab) {
        Event event = Event.valueOfOrNull(eventTab);
        return eventService.getEventTab(event);
    }

}
