package com.example.sidedish.repository

import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.ProductDetail
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(
    private val productDetailRemoteDataSource: ProductDetailRemoteDataSource,
    private val productCountRemoteDataSource: ProductCountRemoteDataSource
) {

    suspend fun loadProductDetail(productId: Int): ProductDetail? {
        return productDetailRemoteDataSource.loadProductDetail(productId)
    }

    suspend fun orderProduct(postRequest: PostRequest): String? {
        return productCountRemoteDataSource.orderProduct(postRequest)
    }
}