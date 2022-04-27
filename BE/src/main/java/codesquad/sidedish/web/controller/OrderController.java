package codesquad.sidedish.web.controller;

import codesquad.sidedish.web.dto.OrderCreateRequest;
import codesquad.sidedish.web.dto.OrderCreateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public OrderCreateResponse orderCreate(@RequestBody OrderCreateRequest createRequest) {
        return new OrderCreateResponse();
    }
}
