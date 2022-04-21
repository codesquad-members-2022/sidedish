package com.example.sidedish.network

import com.bumptech.glide.request.SingleRequest
import com.example.sidedish.data.Body
import com.example.sidedish.data.Food
import com.example.sidedish.data.FoodDetail
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

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
