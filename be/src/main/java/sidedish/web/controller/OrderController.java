package sidedish.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sidedish.service.OrderService;
import sidedish.web.dto.ResponseDto;
import sidedish.web.dto.order.RequestOrderDto;


@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/item")
    public ResponseDto orderItem(@RequestBody RequestOrderDto requestOrderDto) {
        return orderService.addOrder(requestOrderDto);
    }


}
