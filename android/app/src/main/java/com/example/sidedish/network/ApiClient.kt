package com.example.sidedish.network

import com.example.sidedish.data.dto.Item
import com.example.sidedish.data.dto.MenuDetailDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("/items/{categoryId}")
    suspend fun getMenuList(
        @Path("categoryId") category: Int
    ):Response<Item>

    @GET("/items/detail/{id}")
    suspend fun getProductDetail(
        @Path("id") detailHash: Int
    ): Response<MenuDetailDTO>
}
