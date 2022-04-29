package com.example.sidedish.repository

import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.ProductDetail
import com.example.sidedish.network.NetworkUtil
import com.example.sidedish.network.RetrofitAPI
import java.lang.Exception
import javax.inject.Inject

class ProductCountRemoteDataSource @Inject constructor() : ProductDetailDataSource {
    override suspend fun loadProductDetail(productId: Int): ProductDetail? {
        return null
    }

    override suspend fun orderProduct(postRequest: PostRequest): String? {
        val response =  RetrofitAPI.service.orderProduct(postRequest)
        return if (response.isSuccessful) {
            null
        } else {
            try {
                NetworkUtil.getErrorResponse(response.errorBody())?.errorMessage
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}