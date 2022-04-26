package com.example.sidedish.repository

import android.util.Log
import com.example.sidedish.model.ProductDetail
import com.example.sidedish.network.RetrofitAPI
import com.google.gson.Gson

class ProductDetailRemoteDataSource : ProductDetailDataSource {

    override suspend fun loadProductDetail(productId: Int): ProductDetail? {
        val response = RetrofitAPI.service.getProductDetail(productId)
        return if (response.isSuccessful) response.body() else null
    }
}