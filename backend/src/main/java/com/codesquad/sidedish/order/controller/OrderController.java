package com.codesquad.sidedish.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesquad.sidedish.order.dto.OrderItemDto;
import com.codesquad.sidedish.order.service.OrderService;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    private void order(@RequestBody OrderItemDto orderItemDto) {
        orderService.order(orderItemDto);
    }
}
