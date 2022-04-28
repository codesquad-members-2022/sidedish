package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.OrderRequest;
import kr.codesquad.sidedish.dto.Reciept;
import kr.codesquad.sidedish.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{dishId}")
    public ResponseEntity<Reciept> orderDishes(@PathVariable Long dishId,
        @RequestBody OrderRequest orderRequest) {
        orderService.checkOrderPlaceable(dishId, orderRequest);
        return ResponseEntity.ok(orderService.placeOrder(dishId, orderRequest));
    }

}
