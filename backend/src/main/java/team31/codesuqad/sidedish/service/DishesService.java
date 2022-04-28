package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.controller.dto.DetailedDishDto;
import team31.codesuqad.sidedish.controller.dto.DiscountDto;
import team31.codesuqad.sidedish.controller.dto.DishDto;
import team31.codesuqad.sidedish.domain.Deliveries;
import team31.codesuqad.sidedish.domain.Dishes;
import team31.codesuqad.sidedish.domain.Images;
import team31.codesuqad.sidedish.repository.DishesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishesService {

    private final DishesRepository dishesRepository;
    private final DeliveriesService deliveriesService;
    private final DiscountPoliciesService discountPoliciesService;

    public DishesService(DishesRepository dishesRepository, DeliveriesService deliveriesService, DiscountPoliciesService discountPoliciesService) {
        this.dishesRepository = dishesRepository;
        this.deliveriesService = deliveriesService;
        this.discountPoliciesService = discountPoliciesService;
    }

    public List<Dishes> findAll() {
        return dishesRepository.findAll();
    }

    public DetailedDishDto findById(Long dishId) {
        Dishes dish = dishesRepository.findById(dishId);
        discountPoliciesService.mappingDishToDiscountPolicies(dish);
        Deliveries deliveries = deliveriesService.findById(dish.getDeliveryId())
                .orElseThrow(() -> new RuntimeException("딜러버리 정보가 없습니다."));

        return new DetailedDishDto(dish, deliveries);
    }

    public List<DishDto> makeDishDto(List<Dishes> dishes) {
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
