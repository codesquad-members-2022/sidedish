package com.example.sidedish.repository

import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.PostResponse
import com.example.sidedish.model.ProductDetail
import com.example.sidedish.network.RetrofitAPI

class ProductCountRemoteDataSource : ProductDetailDataSource {
    override suspend fun loadProductDetail(productId: Int): ProductDetail? {
        return null
    }

    override suspend fun orderProduct(postRequest: PostRequest): PostResponse? {
        val response =  RetrofitAPI.service.orderProduct(postRequest)
        return if (response.isSuccessful) return response.body() else null
    }
}