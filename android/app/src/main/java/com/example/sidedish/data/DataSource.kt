package com.example.sidedish.data

import retrofit2.Response


interface DataSource {

    suspend fun getMainFoodList(): Response<Food>

    suspend fun getSoupFoodList(): Response<Food>

    suspend fun getSideFoodList(): Response<Food>

    suspend fun getFoodDetail(hashId: String): Response<FoodDetail>
}