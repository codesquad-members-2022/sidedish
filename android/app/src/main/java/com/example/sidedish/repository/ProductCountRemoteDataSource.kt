package com.example.sidedish.repository

import android.util.Log
import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.Error
import com.example.sidedish.model.ProductDetail
import com.example.sidedish.network.NetworkUtil
import com.example.sidedish.network.RetrofitAPI
import okhttp3.ResponseBody
import java.lang.Exception

class ProductCountRemoteDataSource : ProductDetailDataSource {
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