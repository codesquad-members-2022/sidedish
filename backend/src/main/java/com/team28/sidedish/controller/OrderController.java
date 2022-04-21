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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "orders", description = "주문 API")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

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
    public ResponseEntity<Void> postOrder(@RequestBody OrderRequest orderRequest) {

        orderService.order(orderRequest.getProductId(), orderRequest.getQuantity());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
