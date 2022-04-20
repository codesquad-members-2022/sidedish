package com.example.sidedish.data

import com.google.gson.annotations.SerializedName

data class FoodDetail(
    val hash: String?,
    val data: Detail
)

data class Detail(
    @SerializedName("top_image") val topImage: String,
    @SerializedName("thumb_images") val thumbImage: List<String>,
    @SerializedName("product_description") val productDescription: String,
    @SerializedName("point") val point: String,
    @SerializedName("delivery_info") val deliveryInfo: String,
    @SerializedName("delivery_fee") val deliveryFee: String,
    @SerializedName("prices") val prices: List<String>,
    @SerializedName("detail_section") val detailSection: List<String>
)
