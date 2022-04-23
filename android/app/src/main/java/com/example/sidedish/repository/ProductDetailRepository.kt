package com.example.sidedish.repository

import com.example.sidedish.model.ProductDetail

class ProductDetailRepository(private val productDetailImageDataSource: ProductDetailImageDataSource) {

    suspend fun loadProductDetail(categoryId: Int): ProductDetail? {
        return productDetailImageDataSource.loadProductDetailImage(categoryId)
    }
}