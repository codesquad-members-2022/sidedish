package com.codesquad.sidedish.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.codesquad.sidedish.order.domain.Order;
import com.codesquad.sidedish.order.domain.OrderRepository;
import com.codesquad.sidedish.order.dto.OrderItemDto;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void order(OrderItemDto orderItemDto) {
        Order order = orderItemDto.toEntity();
        Order savedOrder = orderRepository.save(order);
        log.info("savedOrder : {}", savedOrder);
    }
}
