package com.example.todo.sidedish.data.remote.order

import com.example.todo.sidedish.data.dto.OrderDto
import javax.inject.Inject

class OrderRemoteDataSource @Inject constructor(
    private val api: OrderApi,
) : OrderDataSource {

    override suspend fun saveOrder(order: OrderDto): String = api.saveOrder(order)
}