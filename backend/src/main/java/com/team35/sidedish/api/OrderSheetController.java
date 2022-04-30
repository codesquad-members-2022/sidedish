package com.team35.sidedish.api;

import com.team35.sidedish.dto.request.OrderSheetRequest;
import com.team35.sidedish.dto.response.OrderSheetResponse;
import com.team35.sidedish.service.OrderSheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "OrderSheetController")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/order-sheets")
public class OrderSheetController {

    private final OrderSheetService orderSheetService;

    @ApiOperation(
            value = "요청한 수량만큼 반찬 주문",
            notes = "반찬 주문하기 클릭 시 요청한 수량만큼  반찬을 주문한다.",
            produces = "application/json",
            response = String.class
    )
    @PostMapping
    public OrderSheetResponse makeOrderSheet(@RequestBody @Valid OrderSheetRequest orderSheetRequest) {
        return orderSheetService.addOrderSheet(orderSheetRequest);
    }
}
