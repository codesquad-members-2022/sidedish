package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.controller.dto.DiscountDto;
import team31.codesuqad.sidedish.controller.dto.DishDto;
import team31.codesuqad.sidedish.controller.dto.EventTabResponse;
import team31.codesuqad.sidedish.domain.*;
import team31.codesuqad.sidedish.repository.EventTabsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    public EventTabResponse getEventTab(Event event) {
        EventTabs eventTab = eventTabsRepository.findByName(event.name());
        List<Dishes> allDishes = dishesService.findAll();

        List<Dishes> dishes = findSameEventTab(allDishes, eventTab.getId());
        mappingDiscountPolicies(dishes);
        Collections.shuffle(dishes);
        dishes = checkNumber(dishes);

        List<DishDto> dishDtos = makeDishDto(dishes);
        return new EventTabResponse(eventTab, dishDtos);
    }

    private List<Dishes> findSameEventTab(List<Dishes> allDishes, Integer eventId) {
        return allDishes.stream()
                .filter(dish -> dish.isSameEvent(eventId))
                .collect(Collectors.toList());
    }

    private void mappingDiscountPolicies(List<Dishes> dishes) {
        Map<Integer, DiscountPolicies> discountPoliciesMap = discountPoliciesService.findAll().stream()
                .collect(Collectors.toMap(DiscountPolicies::getId, Function.identity()));

        for (Dishes dish : dishes) {
            List<DiscountPolicies> discountPolicies = dish.getDiscounts().stream()
                    .map(Discount::getDiscountPolicyId)
                    .map(discountPoliciesMap::get)
                    .collect(Collectors.toList());
            dish.setEventBadge(discountPolicies);
        }
    }

    private List<Dishes> checkNumber(List<Dishes> dishes) {
        if (dishes.size() > 3) {
            return dishes.subList(0, 3);
        }
        return dishes;
    }

    private List<DishDto> makeDishDto(List<Dishes> dishes) {
        List<DishDto> dishDto = new ArrayList<>();
        for (Dishes dish : dishes) {
            List<DiscountDto> discountDtos = dish.getEventBadge().stream()
                    .map(DiscountDto::new)
                    .collect(Collectors.toList());

            Images main = dish.getImages().stream()
                    .filter(images -> images.isSameType("main"))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("메인 이미지가 없습니다."));

            dishDto.add(new DishDto(dish, main, discountDtos));
        }

        return dishDto;
    }

}
