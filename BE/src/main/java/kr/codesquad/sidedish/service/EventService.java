package kr.codesquad.sidedish.service;

import java.util.ArrayList;
import java.util.List;

import kr.codesquad.sidedish.domain.Event;
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


        return new SpecialEdition(events.subList(0, 4));
    }

}
