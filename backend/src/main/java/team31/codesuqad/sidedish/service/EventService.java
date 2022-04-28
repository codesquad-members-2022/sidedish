package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.controller.dto.EventTabDto;
import team31.codesuqad.sidedish.controller.dto.EventTabListDto;
import team31.codesuqad.sidedish.controller.dto.DishDto;
import team31.codesuqad.sidedish.controller.dto.CategoryResponse;
import team31.codesuqad.sidedish.domain.*;
import team31.codesuqad.sidedish.repository.EventTabsRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private EventTabsRepository eventTabsRepository;
    private DishesService dishesService;
    private DiscountPoliciesService discountPoliciesService;

    public EventService(EventTabsRepository eventTabsRepository, DishesService dishesService, DiscountPoliciesService discountPoliciesService) {
        this.eventTabsRepository = eventTabsRepository;
        this.dishesService = dishesService;
        this.discountPoliciesService = discountPoliciesService;
    }

    public EventTabListDto findAll() {
        List<EventTabDto> eventTabList = eventTabsRepository.findAll()
                .stream()
                .map(EventTabDto::new)
                .collect(Collectors.toList());

        return new EventTabListDto(eventTabList);
    }

    public CategoryResponse getEventTab(Event event) {
        EventTabs eventTab = eventTabsRepository.findByName(event.name());
        List<Dishes> allDishes = dishesService.findAll();

        List<Dishes> dishes = findSameEventTab(allDishes, eventTab);
        discountPoliciesService.mappingDiscountPolicies(dishes);
        dishes = checkNumber(dishes);
        Collections.shuffle(dishes);

        List<DishDto> dishDtos = dishesService.makeDishDto(dishes);
        return new CategoryResponse(eventTab, dishDtos);
    }

    private List<Dishes> findSameEventTab(List<Dishes> allDishes, EventTabs eventTab) {
        return allDishes.stream()
                .filter(dish -> dish.isSameEvent(eventTab))
                .collect(Collectors.toList());
    }

    private List<Dishes> checkNumber(List<Dishes> dishes) {
        if (dishes.size() > 3) {
            return dishes.subList(0, 3);
        }
        return dishes;
    }

}
