package com.example.sideDish.network

import com.example.sideDish.network.dto.DetailDto
import com.example.sideDish.network.dto.SideDishDto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SideDishRetrofitService {

    @GET("main")
    suspend fun getMainMenu(): Response<SideDishDto>

    @GET("side")
    suspend fun getSideMenu(): Response<SideDishDto>

    @GET("soup")
    suspend fun getSoupMenu(): Response<SideDishDto>

    @GET("detail/{detailHash}")
    suspend fun getDetail(@Path("detailHash") detailHash: String): Response<DetailDto>

    companion object {
        private const val base_url = "https://api.codesquad.kr/onban/"

        fun create(): SideDishRetrofitService {
            return Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SideDishRetrofitService::class.java)
        }
    }
}