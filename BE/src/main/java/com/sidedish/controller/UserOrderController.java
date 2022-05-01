package com.sidedish.controller;

import com.sidedish.dto.SideDishOrderDto;
import com.sidedish.service.SideDishService;
import com.sidedish.service.UserOrderService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api", produces = "application/json; charset=utf8")
public class UserOrderController {

    private final UserOrderService userOrderService;
    private final SideDishService sideDishService;

    @PostMapping("sidedish-order")
    public ResponseEntity<ResponseMessage> orderSideDishDetails(@RequestBody SideDishOrderDto sideDishOrderDto, HttpSession httpSession) {
        String email = (String) httpSession.getAttribute("email");
        if (email == null) {
            ResponseMessage message = new ResponseMessage(HttpStatus.UNAUTHORIZED, "로그인이 되어있지 않습니다.");
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }

        Integer stock = sideDishService.getStockOfSideDish(sideDishOrderDto.getSidedishId());
        Integer quantity = sideDishOrderDto.getQuantity();
        if (quantity > stock) {
            ResponseMessage message = new ResponseMessage(HttpStatus.NOT_FOUND, "재고가 부족합니다.", email);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        int changedStock = stock - quantity;
        userOrderService.saveUserOrder(sideDishOrderDto, email, changedStock);
        ResponseMessage message = new ResponseMessage(HttpStatus.OK, "주문이 처리되었습니다.", email);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
