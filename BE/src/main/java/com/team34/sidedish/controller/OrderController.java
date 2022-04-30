package com.team34.sidedish.controller;

import com.team34.sidedish.dto.OrderRequest;
import com.team34.sidedish.exception.OutOfStockException;
import com.team34.sidedish.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity order(@RequestBody OrderRequest orderRequest) {
        try {
            orderService.addOrder(orderRequest);
            return new ResponseEntity("주문에 성공하였습니다.", HttpStatus.OK);
        } catch (OutOfStockException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }
}
