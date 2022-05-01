package com.example.sideDish.data.source

import com.example.sideDish.network.OrderRetrofitService
import com.example.sideDish.network.dto.OrderDto
import javax.inject.Inject

class OrderRepository @Inject constructor(private val api: OrderRetrofitService) {
    suspend fun sendOrder(order: OrderDto): Boolean {
        return api.sendOrder(order) == SUCCESS_CODE
    }

    companion object {
        const val SUCCESS_CODE = "ok"
    }
}