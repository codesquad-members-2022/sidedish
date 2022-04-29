package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.SpecialEdition;
import kr.codesquad.sidedish.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final Logger log = LoggerFactory.getLogger(EventController.class);
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/special")
    public ResponseEntity<SpecialEdition> getSpecial() {
        log.info("request special edition info");
        SpecialEdition eventDishes = eventService.findEventDishes();
        return ResponseEntity.ok(eventDishes);
    }

}
