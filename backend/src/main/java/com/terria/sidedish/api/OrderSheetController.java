package com.terria.sidedish.api;

import com.terria.sidedish.dto.request.OrderSheetRequest;
import com.terria.sidedish.dto.response.OrderSheetResponse;
import com.terria.sidedish.service.OrderSheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "OrderSheetController")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/order-sheets")
public class OrderSheetController {

    private final OrderSheetService orderSheetService;

    @ApiOperation(
            value = "특정 기획전 조회",
            notes = "특정 기획전을 조회한다.",
            produces = "application/json",
            response = String.class
    )
    @PostMapping
    public OrderSheetResponse makeOrderSheet(@ModelAttribute OrderSheetRequest orderSheetRequest) {
        return orderSheetService.addOrderSheet(orderSheetRequest);
    }
}
