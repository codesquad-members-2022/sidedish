package com.codesquad.sidedish.order;

import com.codesquad.sidedish.dish.DishRepository;
import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.DishDelivery;
import com.codesquad.sidedish.exception.ErrorCode;
import com.codesquad.sidedish.exception.unchecked.NotFoundException;
import com.codesquad.sidedish.order.domain.Order;
import com.codesquad.sidedish.order.domain.OrderDelivery;
import com.codesquad.sidedish.order.domain.User;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final DishRepository dishRepository;

    public void order(String githubId, Integer dishId, Integer quantity) {
        User user = userRepository.findByGithubId(githubId)
            .orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND));

        Dish dish = dishRepository.findById(dishId)
            .orElseThrow(() -> new NotFoundException(ErrorCode.DISH_NOT_FOUND));

        // 반찬 판매 후 저장
        dish.sold(quantity);
        dishRepository.save(dish);

        // 반찬의 정보에 따라 주문 저장
        Order order = new Order(dish.getId(), dish.getDiscountPrice(), quantity);
        Set<OrderDelivery> deliveries = toOrderDeliveries(dish.getDeliveries());
        order.setDeliveries(deliveries);

        user.addOrder(order);
        user.addPoint(order.getRewardPoint());
        userRepository.save(user);
    }

    private Set<OrderDelivery> toOrderDeliveries(Set<DishDelivery> deliveries) {
        return deliveries.stream()
            .map(DishDelivery::getCode)
            .map(OrderDelivery::new)
            .collect(Collectors.toSet());
    }
}
