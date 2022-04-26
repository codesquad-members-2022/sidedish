package com.team25.sidedish.controller;

import com.team25.sidedish.dto.request.ProductStockChangeRequest;
import com.team25.sidedish.dto.response.ProductDetailResponse;
import com.team25.sidedish.dto.response.ProductResponse;
import com.team25.sidedish.dto.response.ProductStockChangeResponse;
import com.team25.sidedish.dto.response.ErrorResponse;
import com.team25.sidedish.service.aggregate.AggregateProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "products", description = "상품 API")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final AggregateProductService aggregateProductService;

    @Operation(summary = "상품 목록 조회",
            description = "특정 카테고리에 해당하는 상품 목록을 조회합니다",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "상품 목록 조회 성공",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(responseCode = "400",
                            description = "상품 목록 조회 실패 - 해당 카테고리가 존재하지 않음",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping
    public List<ProductResponse> getProducts(@RequestParam Long categoryId) {
        return aggregateProductService.getProductList(categoryId);
    }

    @Operation(summary = "상품 상세 조회",
            description = "상품의 상세 정보를 조회합니다",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "상품 상세 조회 성공",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductDetailResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(responseCode = "400",
                            description = "상품 조회 실패 - 해당 상품이 존재하지 않음",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping("/{productId}")
    public ProductDetailResponse getProductDetail(@PathVariable Long productId) {
        return aggregateProductService.getProductDetailList(productId);
    }

    @Operation(summary = "상품 주문 요청",
            description = "상품 주문 요청에 따라 상품의 재고개수를 변경합니다",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "상품 주문 성공",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ProductStockChangeResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(responseCode = "400",
                            description = "상품 주문 실패 - 상품 재고가 부족함, 주문 수량이 음수, 존재하지 않는 상품 번호",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class)
                                    )
                            }
                    )
            }
    )
    @PatchMapping
    public ProductStockChangeResponse modifyProductStock(
            @RequestBody @Validated ProductStockChangeRequest productStockChangeRequest) {
        return aggregateProductService.updateProductStock(productStockChangeRequest);
    }
}
