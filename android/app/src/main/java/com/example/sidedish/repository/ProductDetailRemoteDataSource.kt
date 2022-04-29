package com.example.sidedish.repository

import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.Error
import com.example.sidedish.model.ProductDetail
import com.example.sidedish.network.RetrofitAPI
import javax.inject.Inject

class ProductDetailRemoteDataSource @Inject constructor() : ProductDetailDataSource {

    override suspend fun loadProductDetail(productId: Int): ProductDetail? {
        val response = RetrofitAPI.service.getProductDetail(productId)
        return if (response.isSuccessful) response.body() else null
    }

    override suspend fun orderProduct(postRequest: PostRequest): String? {
        return null
    }
}