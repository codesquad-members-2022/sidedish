package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductImageResponse;

import java.util.List;

public interface ProductImageService {
    List<ProductImageResponse> findProductImages(Long productId);
}
