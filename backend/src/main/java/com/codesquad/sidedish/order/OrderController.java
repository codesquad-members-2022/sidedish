package com.codesquad.sidedish.order;

import com.codesquad.sidedish.order.dto.OrderRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void order(@RequestBody @Valid OrderRequest orderRequest) {
        orderService.order(
            orderRequest.getGithubId(),
            orderRequest.getDishId(),
            orderRequest.getQuantity()
        );
    }
}
