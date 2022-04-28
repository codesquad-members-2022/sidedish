package com.example.sideDish.network

import com.example.sideDish.network.dto.OrderDto
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderRetrofitService {
    @POST("R1jrzaT3keuAknigsCsOhDwo")
    suspend fun sendOrder(@Body payload: OrderDto): String

    companion object {
        private const val baseUrl =
            "https://hooks.slack.com/services/T74H5245A/B7A8M1W3F/"

        private val gson = GsonBuilder().setLenient().create()

        fun create(): OrderRetrofitService {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(OrderRetrofitService::class.java)
        }
    }
}