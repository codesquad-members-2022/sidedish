package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductDetailResponse;
import com.team28.sidedish.controller.dto.ProductImageResponse;
import com.team28.sidedish.controller.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MockProductDetailService implements ProductDetailService {

    private final ProductService productService;
    private final ProductImageService productImageService;

    @Override
    public ProductDetailResponse findProductDetail(Long productId) {
        ProductResponse product = productService.findProduct(productId);
        int stock = productService.findProductStock(productId);

        List<ProductImageResponse> productImages = productImageService.findProductImages(productId);

        return ProductDetailResponse.from(product, productImages, stock);
    }
}
