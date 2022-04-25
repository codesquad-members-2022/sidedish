package com.team25.sidedish.controller;

import com.team25.sidedish.dto.request.ProductStockChangeRequest;
import com.team25.sidedish.dto.response.ProductDetailResponse;
import com.team25.sidedish.dto.response.ProductResponse;
import com.team25.sidedish.dto.response.ProductStockChangeResponse;
import com.team25.sidedish.service.aggregate.AggregateProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final AggregateProductService aggregateProductService;

    @GetMapping
    public List<ProductResponse> getProducts(@RequestParam Long categoryId) {
        return aggregateProductService.getProductList(categoryId);
    }

    @GetMapping("/{productId}")
    public ProductDetailResponse getProductDetail(@PathVariable Long productId) {
        return aggregateProductService.getProductDetailList(productId);
    }

    @PatchMapping
    public ProductStockChangeResponse modifyProductStock(@RequestBody ProductStockChangeRequest productStockChangeRequest) {
        return aggregateProductService.updateProductStock(productStockChangeRequest);
    }
}
