package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team31.codesuqad.sidedish.controller.dto.EventTabListDto;
import team31.codesuqad.sidedish.controller.dto.CategoryResponse;
import team31.codesuqad.sidedish.domain.*;
import team31.codesuqad.sidedish.repository.EventTabRepository;
import team31.codesuqad.sidedish.type.EventType;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class EventService {

    private final EventTabRepository eventTabRepository;
    private final DishService dishService;

    public EventService(EventTabRepository eventTabRepository, DishService dishService) {
        this.eventTabRepository = eventTabRepository;
        this.dishService = dishService;
    }

    public EventTabListDto findAll() {
        List<Event> events = eventTabRepository.findAll();
        return new EventTabListDto(events);
    }

    public CategoryResponse getEventTab(EventType eventType) {
        Event eventTab = eventTabRepository.findByName(eventType.name())
                .orElseThrow(() -> new NoSuchElementException("이벤트 탭이 존재하지 않습니다."));

        List<Dish> dishes = dishService.findThreeByEventTabId(eventTab.getId());

        return new CategoryResponse(eventTab, dishes);
    }

}
