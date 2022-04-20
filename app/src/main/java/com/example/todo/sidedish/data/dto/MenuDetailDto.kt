package com.example.todo.sidedish.data.dto

import com.example.todo.sidedish.domain.model.MenuDetail
import com.google.gson.annotations.SerializedName

data class MenuDetailDto(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("hash")
    val hash: String
)

data class Data(
    @SerializedName("delivery_fee")
    val deliveryFee: String,
    @SerializedName("delivery_info")
    val deliveryInfo: String,
    @SerializedName("detail_section")
    val detailSection: List<String>,
    @SerializedName("point")
    val point: String,
    @SerializedName("prices")
    val prices: List<String>,
    @SerializedName("product_description")
    val productDescription: String,
    @SerializedName("thumb_images")
    val thumbImages: List<String>,
    @SerializedName("top_image")
    val topImage: String
)

fun Data.toMenuDetail(): MenuDetail =  MenuDetail(deliveryFee, deliveryInfo, detailSection, point, prices, productDescription, thumbImages, topImage )