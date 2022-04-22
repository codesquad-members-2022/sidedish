package com.example.sidedish

data class MenuData(
    val count: Int,
    val products: List<Products>
)

data class Products(
    val productId: Int,
    val productName: String,
    val imageURL: String,
    val description: String,
    val price: Int,
    val discountPrice: Int,
    val discountName: String?
)