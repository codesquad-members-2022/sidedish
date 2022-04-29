package com.example.sidedish.model

data class PostRequest(
    val productId: Int,
    val userId: String,
    val quantity: Int,
    val price: Int
)
