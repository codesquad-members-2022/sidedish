package com.example.sidedish.repository

import com.example.sidedish.model.ProductDetail

class ProductDetailRepository(private val productDetailRemoteDataSource: ProductDetailRemoteDataSource) {

    suspend fun loadProductDetail(productId: Int): ProductDetail? {
        return productDetailRemoteDataSource.loadProductDetail(productId)
    }
}