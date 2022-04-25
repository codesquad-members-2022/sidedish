package com.example.sideDish.network.dto

import com.google.gson.annotations.SerializedName

data class DetailData(
    @SerializedName("delivery_fee")
    val deliveryFee: String,
    @SerializedName("delivery_info")
    val deliveryInfo: String,
    @SerializedName("detail_section")
    val detailSection: List<String>,
    val point: String,
    val prices: List<String>,
    @SerializedName("product_description")
    val productDescription: String,
    @SerializedName("thumb_images")
    val thumbImages: List<String>,
    @SerializedName("top_image")
    val topImage: String
)

data class DetailDto(
    val hash: String,
    @SerializedName("data")
    val detail: DetailData
)
