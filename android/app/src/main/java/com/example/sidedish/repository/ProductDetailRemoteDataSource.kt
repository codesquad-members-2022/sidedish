package com.example.sidedish.repository

import com.example.sidedish.model.ProductDetail

interface ProductDetailRemoteDataSource {

    suspend fun loadProductDetail(productId: Int): ProductDetail?
}