package com.example.todo.sidedish.data.remote.order

import com.example.todo.sidedish.config.ORDER
import com.example.todo.sidedish.data.dto.OrderDto
import retrofit2.http.*

interface OrderApi {

    @POST(ORDER)
    suspend fun saveOrder(@Body payload: OrderDto): String
}