package com.example.todo.sidedish.domain.model

import com.example.todo.sidedish.data.dto.OrderDto

data class Order(
    val channel: String,
    val username: String,
    val text: String,
    val iconEmoji: String,
)

fun Order.toOrderDto(): OrderDto = OrderDto(channel, username, text, iconEmoji)