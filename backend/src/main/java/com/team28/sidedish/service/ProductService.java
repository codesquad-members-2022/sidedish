package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.ProductListResponse;
import com.team28.sidedish.controller.dto.ProductResponse;

public interface ProductService {
    ProductListResponse findProductList(Long categoryId);
    ProductResponse findProduct(Long productId);
    int findProductStock(Long productId);
}
