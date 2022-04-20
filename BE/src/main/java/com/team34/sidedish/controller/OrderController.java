package com.team34.sidedish.controller;

import com.team34.sidedish.dto.OrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public String order(@RequestBody OrderRequest orderRequest) {
        // TODO: RestController에서 리다이렉트하는 방법 찾아보기
        return "redirect:/dishes";
    }
}
