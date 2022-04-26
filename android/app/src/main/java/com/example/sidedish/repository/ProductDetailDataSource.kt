package com.example.sidedish.repository

import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.PostResponse
import com.example.sidedish.model.ProductDetail

interface ProductDetailDataSource {

    suspend fun loadProductDetail(productId: Int): ProductDetail?

    suspend fun orderProduct(postRequest: PostRequest): PostResponse?
}