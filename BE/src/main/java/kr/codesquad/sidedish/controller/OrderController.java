package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.OrderRequest;
import kr.codesquad.sidedish.dto.Reciept;
import kr.codesquad.sidedish.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{dishId}")
    public ResponseEntity<Reciept> orderDishes(@PathVariable Long dishId, @RequestBody OrderRequest orderRequest) {
        orderService.checkOrderPlaceable(dishId, orderRequest);
        log.info("request order dishId = [{}], orderRequest = [{}]", dishId, orderRequest);
        return ResponseEntity.ok(orderService.placeOrder(dishId, orderRequest));
    }

}
