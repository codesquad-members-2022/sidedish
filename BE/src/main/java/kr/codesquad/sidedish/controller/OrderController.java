package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.OrderRequest;
import kr.codesquad.sidedish.dto.Reciept;
import kr.codesquad.sidedish.service.OrderService;
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
    public ResponseEntity<Reciept> orderDishes(@RequestBody OrderRequest orderRequest) {
        orderService.isOrderPlaceable(orderRequest);
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

}
