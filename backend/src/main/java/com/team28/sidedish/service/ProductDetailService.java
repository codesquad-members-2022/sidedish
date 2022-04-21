package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductDetailResponse;

public interface ProductDetailService {
    ProductDetailResponse findProductDetail(Long productId);
}
