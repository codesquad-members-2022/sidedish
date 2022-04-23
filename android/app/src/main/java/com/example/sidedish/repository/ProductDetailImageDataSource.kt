package com.example.sidedish.repository

import com.example.sidedish.model.ProductDetail
import com.example.sidedish.network.RetrofitAPI
import com.google.gson.Gson

class ProductDetailImageDataSource : ProductDetailDataSource {

    private val gson = Gson()
    override suspend fun loadProductDetailImage(categoryId: Int): ProductDetail? {
        val response = RetrofitAPI.service.getProductDetail(categoryId)
        return if (response.isSuccessful) response.body() else null
    }
}