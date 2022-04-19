package com.example.todo.sidedish.data.remote

import com.example.todo.sidedish.data.dto.MenuDto
import retrofit2.http.GET

interface OnBanApi {

    @GET("main")
    suspend fun getMain(): MenuDto

    @GET("soup")
    suspend fun getSoup(): MenuDto

    @GET("side")
    suspend fun getSide(): MenuDto

}