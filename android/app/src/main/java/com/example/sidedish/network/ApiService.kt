package com.example.sidedish.network

import com.example.sidedish.model.MenuData
import com.example.sidedish.model.ProductDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("products?categoryId=1")
    suspend fun getMainMenu(): Response<MenuData>

    @Headers("Content-Type: application/json")
    @GET("products?categoryId=2")
    suspend fun getSoupMenu(): Response<MenuData>

    @Headers("Content-Type: application/json")
    @GET("products?categoryId=3")
    suspend fun getSideDish(): Response<MenuData>

    @Headers("Content-Type: application/json")
    @GET("products/{productId}")
    suspend fun getProductDetail(@Path("productId") id: Int): Response<ProductDetail>
}