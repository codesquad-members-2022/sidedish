package com.team28.sidedish.controller;

import com.team28.sidedish.controller.dto.ProductListResponse;
import com.team28.sidedish.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService mockProductService;

    @Operation(
            summary = "상품 목록 조회",
            description = "카테고리별 상품 목록 및 등록된 상품 개수를 조회합니다",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "상품 목록 조회 성공",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductListResponse.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping("/products")
    public ProductListResponse productList(@RequestParam Long categoryId) {
        return mockProductService.findProductList(categoryId);
    }
}
