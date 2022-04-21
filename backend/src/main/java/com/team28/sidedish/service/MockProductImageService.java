package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductImageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockProductImageService implements ProductImageService {

    @Override
    public List<ProductImageResponse> findProductImages(Long productId) {
        return List.of(
                new ProductImageResponse(1L, "http://fakeurl.com/image1.jpg", true, 1),
                new ProductImageResponse(2L, "http://fakeurl.com/image2.jpg", false, 1),
                new ProductImageResponse(3L, "http://fakeurl.com/image3.jpg", false, 2)
        );
    }
}
