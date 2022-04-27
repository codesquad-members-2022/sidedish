package com.example.todo.sidedish.domain.model

data class MenuDetail(
    val topImage:String,
    val thumbnailImages: List<String>,
    val description: String,
    val point:String,
    val deliveryInfo: String,
    val deliveryFee:String,
    val originPrice: String?,
    val sPrice: String,
    val detailImages:List<String>,
)