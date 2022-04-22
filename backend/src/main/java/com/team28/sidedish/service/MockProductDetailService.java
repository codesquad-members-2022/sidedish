package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductDetailResponse;
import com.team28.sidedish.controller.dto.ProductImageResponse;
import com.team28.sidedish.controller.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MockProductDetailService {

    private final MockProductService productService;
    private final MockProductImageService productImageService;

    public ProductDetailResponse findProductDetail(Long productId) {
        ProductResponse product = productService.findProduct(productId);
        int stock = productService.findProductStock(productId);

        List<ProductImageResponse> productImages = productImageService.findProductImages(productId);

        return ProductDetailResponse.from(product, productImages, stock);
    }
}
