package com.example.sidedish.model

data class PostRequest(
    val productId: Int,
    val memberId: Int,
    val quantity: Int,
    val price: Int
)
