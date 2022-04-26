package com.example.sidedish.network

import com.example.sidedish.data.FoodDetail
import com.example.sidedish.data.Item
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("/items/{categoryId}")
    suspend fun getMenuList(
        @Path("categoryId") category: Int
    ):Response<Item>

    @GET("/onban/detail/{detail_hash}")
    suspend fun getProductDetail(
        @Path("detail_hash") detailHash: String
    ): Response<FoodDetail>
}
