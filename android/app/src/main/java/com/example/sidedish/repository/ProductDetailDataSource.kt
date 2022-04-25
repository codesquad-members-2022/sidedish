package com.example.sidedish.repository

import com.example.sidedish.model.ProductDetail

interface ProductDetailDataSource {

    suspend fun loadProductDetail(productId: Int): ProductDetail?
}