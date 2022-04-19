package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductListResponse;

public interface ProductService {
    ProductListResponse findProductList(Long categoryId);
}
