package com.example.sidedish.network

import com.example.sidedish.data.Body
import com.example.sidedish.data.Food
import com.example.sidedish.data.FoodDetail
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    companion object {
        private const val BASE_URL = "https://api.codesquad.kr"

        fun create(): ApiClient {

            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)

        }
    }
}