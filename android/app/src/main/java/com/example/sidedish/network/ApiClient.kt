package com.example.sidedish.network

import com.example.sidedish.data.Food
import com.example.sidedish.data.FoodDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("/onban/main")
    suspend fun getMainFoodList(): Response<Food>

    @GET("/onban/soup")
    suspend fun getSoupFoodList(): Response<Food>

    @GET("/onban/side")
    suspend fun getSideFoodList(): Response<Food>

    @GET("/onban/detail/{detail_hash}")
    suspend fun getProductDetail(
        @Path("detail_hash") detailHash: String
    ): Response<FoodDetail>
}
