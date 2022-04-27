package com.example.todo.sidedish.data.remote.order

import com.example.todo.sidedish.data.dto.OrderDto

interface OrderDataSource {

    suspend fun saveOrder(order: OrderDto): String
}