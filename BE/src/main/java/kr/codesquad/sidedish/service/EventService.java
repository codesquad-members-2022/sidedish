package kr.codesquad.sidedish.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.sidedish.domain.Event;
import kr.codesquad.sidedish.dto.EventResponse;
import kr.codesquad.sidedish.dto.SpecialEdition;
import kr.codesquad.sidedish.repository.JdbcEventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final JdbcEventRepository jdbcEventRepository;

    public EventService(JdbcEventRepository jdbcEventRepository) {
        this.jdbcEventRepository = jdbcEventRepository;
    }


    public SpecialEdition findEventDishes() {
        List<Event> events = new ArrayList<>();
        jdbcEventRepository.findAll().forEach(events::add);

        return new SpecialEdition(convertEvents(events));
    }

    private List<EventResponse> convertEvents(List<Event> events) {
        List<EventResponse> eventResponses = events.stream()
                .map(EventResponse::from)
                .collect(Collectors.toList());

        eventResponses.forEach(EventResponse::shuffleDishes);
        Collections.shuffle(eventResponses);

        return eventResponses.subList(0, 4);
    }
}
