package com.example.sidedish.network

import com.example.sidedish.model.MenuData
import com.example.sidedish.model.PostRequest
import com.example.sidedish.model.Error
import com.example.sidedish.model.ProductDetail
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("products?categoryId=1")
    suspend fun getMainMenu(): Response<MenuData>

    @GET("products?categoryId=2")
    suspend fun getSoupMenu(): Response<MenuData>

    @GET("products?categoryId=3")
    suspend fun getSideDish(): Response<MenuData>

    @GET("products/{productId}")
    suspend fun getProductDetail(@Path("productId") productId: Int): Response<ProductDetail>

    @POST("orders")
    suspend fun orderProduct(@Body postRequest: PostRequest): Response<Error>
}