package com.team28.sidedish.controller;

import com.team28.sidedish.controller.dto.ProductDetailResponse;
import com.team28.sidedish.controller.dto.ProductListResponse;
import com.team28.sidedish.service.ProductDiscountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "products", description = "상품 조회 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductDiscountService productDiscountService;

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
    @GetMapping
    public ProductListResponse productList(@RequestParam Long categoryId) {
        return productDiscountService.findProductList(categoryId);
    }

    @Operation(
            summary = "상품 상세 조회",
            description = "상품의 상세 정보 및 상세설명 이미지를 조회합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "상품 상세 조회 성공",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDetailResponse.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping("/{productId}")
    public ProductDetailResponse productDetail(@PathVariable Long productId) {
        return productDiscountService.findProductDetail(productId);
    }
}
