package com.example.todo.sidedish.data.remote

import com.example.todo.sidedish.data.dto.MenuDetailDto
import com.example.todo.sidedish.data.dto.MenuDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OnBanApi {

    @GET("main")
    suspend fun getMain(): MenuDto

    @GET("soup")
    suspend fun getSoup(): MenuDto

    @GET("side")
    suspend fun getSide(): MenuDto

    @GET("detail/{detail_hash}")
    suspend fun getDetail(@Path("detail_hash") hash: String): MenuDetailDto

    companion object {
        const val ERROR_MESSAGE = "서버에 접속을 실패했습니다"
    }
}