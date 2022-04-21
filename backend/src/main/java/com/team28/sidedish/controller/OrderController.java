package com.team28.sidedish.controller;

import com.team28.sidedish.controller.dto.OrderRequest;
import com.team28.sidedish.exception.ErrorResponse;
import com.team28.sidedish.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "orders", description = "주문 API")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final String OUT_OF_STOCK = "재고 수량이 부족합니다.";

    @Operation(summary = "주문 등록",
            description = "하나의 상품에 대해 주문을 등록합니다.",
            responses = {
                @ApiResponse(responseCode = "201",
                        description = "주문 등록 성공"
                ),
                @ApiResponse(responseCode = "400",
                        description = "주문 등록 실패",
                        content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                        }
                )
            }
    )
    @PostMapping("/orders")
    public ResponseEntity<ErrorResponse> postOrder(@RequestBody OrderRequest orderRequest) {
        if (orderService.isEnoughStockCount(orderRequest.getProductId(), orderRequest.getQuantity())) {
            return ResponseEntity.badRequest().body(ErrorResponse.builder()
                    .errorCode(HttpStatus.BAD_REQUEST.value())
                    .errorName(HttpStatus.BAD_REQUEST.name())
                    .errorMessage(OUT_OF_STOCK)
                    .build());
        }

        orderService.updateStock(orderRequest.getProductId(), orderRequest.getQuantity());
        return ResponseEntity.noContent().build();
    }
}
