package sidedish.com.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sidedish.com.controller.model.OrderSaveRequest;
import sidedish.com.controller.model.OrderSaveResponse;
import sidedish.com.service.OrderService;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/api/products/{id}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderSaveResponse order(@PathVariable Long id,
        @RequestBody @Valid OrderSaveRequest orderSaveRequest) {
        return orderService.save(id, orderSaveRequest.getCount());
    }

}
