package com.example.todo.sidedish.data.repository

import com.example.todo.sidedish.data.remote.order.OrderRemoteDataSource
import com.example.todo.sidedish.domain.OrderRepository
import com.example.todo.sidedish.domain.model.Order
import com.example.todo.sidedish.domain.model.toOrderDto
import javax.inject.Inject

class ProductOrderRepositoryImpl @Inject constructor(
    private val orderRemoteDataSource: OrderRemoteDataSource,
) : OrderRepository {
    override suspend fun saveOrder(order: Order): Result<String> {
        return kotlin.runCatching {
            orderRemoteDataSource.saveOrder(order.toOrderDto())
        }
    }

}