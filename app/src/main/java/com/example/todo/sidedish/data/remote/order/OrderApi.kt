package com.example.todo.sidedish.data.remote.order

import com.example.todo.sidedish.data.dto.OrderDto
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface OrderApi {

    @FormUrlEncoded
    @POST("")
    suspend fun saveOrder(@Field("payload") order: OrderDto): String
}