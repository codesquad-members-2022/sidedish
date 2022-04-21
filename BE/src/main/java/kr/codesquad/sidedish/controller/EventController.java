package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.SpecialEdition;
import kr.codesquad.sidedish.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/special")
    public ResponseEntity<SpecialEdition> getSpecial() {
        SpecialEdition eventDishes = eventService.findEventDishes();
        return ResponseEntity.ok(eventDishes);
    }

}
