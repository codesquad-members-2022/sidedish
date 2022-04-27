package com.sidedish.controller;

import com.sidedish.dto.SideDishOrderDto;
import com.sidedish.service.UserOrderService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class UserOrderController {

    private final UserOrderService userOrderService;

    @PostMapping("sidedish-order")
    public ResponseEntity orderSideDishDetails(@RequestBody SideDishOrderDto sideDishOrderDto, HttpSession httpSession) {
        String email = (String) httpSession.getAttribute("email");
        log.info("dto: {}", sideDishOrderDto);

        if (email == null) {
            return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);
        }
        userOrderService.saveUserOrder(sideDishOrderDto, "abc@abc");
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
