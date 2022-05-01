package com.example.sideDish.data.model

data class FoodDetail(
    val deliveryFee: String,
    val deliveryInfo: String,
    val detailImageUrls: List<String>,
    val point: String,
    val originalPrice: String,
    val discountedPrice: String,
    val productDescription: String,
    val thumbImageUrls: List<String>,
    val topImageUrl: String
)

fun FoodDetail.isEmpty(): Boolean {
    return discountedPrice.isEmpty()
}