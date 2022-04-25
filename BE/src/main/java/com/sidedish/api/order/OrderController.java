package com.sidedish.api.order;

import com.sidedish.api.ResultDto;
import com.sidedish.api.order.dto.OrderRequest;
import com.sidedish.exception.QuantityException;
import com.sidedish.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResultDto makeOrder(@Valid @RequestBody OrderRequest orderRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new QuantityException();
        }
        return orderService.order(orderRequest.getId(), orderRequest.getQuantity());
    }
}
