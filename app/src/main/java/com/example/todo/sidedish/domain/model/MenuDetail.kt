package com.example.todo.sidedish.domain.model

data class MenuDetail(
    val deliveryFee:String,
    val deliveryInfo: String,
    val detailImages:List<String>,
    val point:String,
    val prices: List<String>,
    val description: String,
    val thumbnailImages: List<String>,
    val topImage:String

)