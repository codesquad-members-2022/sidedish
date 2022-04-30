package com.team34.sidedish.service;

import com.team34.sidedish.domain.Dish;
import com.team34.sidedish.domain.Order;
import com.team34.sidedish.dto.OrderRequest;
import com.team34.sidedish.exception.OutOfStockException;
import com.team34.sidedish.repository.DishRepository;
import com.team34.sidedish.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;

    public OrderService(OrderRepository orderRepository, DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
    }

    public void addOrder(OrderRequest orderRequest) {
        Long dishId = orderRequest.getDishId();
        int quantity = orderRequest.getQuantity();
        Dish dish = dishRepository.findById(dishId).orElseThrow();

        if (dish.isOrderable(quantity)) {
            dish.order(quantity);
            dishRepository.save(dish);
            Order order = orderRequest.toOrder();
            orderRepository.save(order);
            return;
        }
        throw new OutOfStockException("재고가 부족합니다.");
    }
}
