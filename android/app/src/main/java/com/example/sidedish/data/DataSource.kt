package com.example.sidedish.data

import retrofit2.Response


interface DataSource {

    suspend fun getMenuList(category: Int): Response<Item>

    suspend fun getFoodDetail(hashId: String): Response<FoodDetail>
}