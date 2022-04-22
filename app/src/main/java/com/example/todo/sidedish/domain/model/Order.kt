package com.example.todo.sidedish.domain.model

import com.example.todo.sidedish.data.dto.OrderDetail
import com.example.todo.sidedish.data.dto.OrderDto

data class Order(
    val order: OrderDetail,
)

fun Order.toOrderDto(): OrderDto = OrderDto(order)