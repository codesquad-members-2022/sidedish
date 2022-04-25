package sidedish.com.controller;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sidedish.com.service.OrderService;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/api/products/{id}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Long order(@PathVariable Long id, @RequestBody Map<String, Integer> map) {
        int count = map.get("count");
        return orderService.save(id, count);
    }
}
