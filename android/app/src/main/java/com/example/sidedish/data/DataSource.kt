package com.example.sidedish.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Response
import javax.inject.Singleton


interface DataSource {

    suspend fun getMainFoodList(): Response<Food>

    suspend fun getSoupFoodList(): Response<Food>

    suspend fun getSideFoodList(): Response<Food>

    suspend fun getFoodDetail(hashId: String): Response<FoodDetail>
}