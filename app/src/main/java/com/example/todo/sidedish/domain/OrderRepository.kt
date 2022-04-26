package com.example.todo.sidedish.domain

import com.example.todo.sidedish.domain.model.Order

interface OrderRepository {

    suspend fun saveOrder(order: Order): String
}