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

    private final ProductService mockProductService;
    private final ProductImageService mockProductImageService;

    @Override
    public ProductDetailResponse findProductDetail(Long productId) {
        ProductResponse product = mockProductService.findProduct(productId);
        int stock = mockProductService.findProductStock(productId);

        List<ProductImageResponse> productImages = mockProductImageService.findProductImages(productId);

        return ProductDetailResponse.from(product, productImages, stock);
    }
}
