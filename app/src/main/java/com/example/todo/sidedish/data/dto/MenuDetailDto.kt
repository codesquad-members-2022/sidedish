package com.example.todo.sidedish.data.dto

import com.example.todo.sidedish.domain.model.MenuDetail
import com.google.gson.annotations.SerializedName

data class MenuDetailDto(
    @SerializedName("data")
    val `data`: DetailInfo,
    @SerializedName("hash")
    val hash: String
)

data class DetailInfo(

    @SerializedName("top_image")
    val topImage: String,
    @SerializedName("thumb_images")
    val thumbImages: List<String>,
    @SerializedName("product_description")
    val productDescription: String,
    @SerializedName("point")
    val point: String,
    @SerializedName("delivery_info")
    val deliveryInfo: String,
    @SerializedName("delivery_fee")
    val deliveryFee: String,
    @SerializedName("prices")
    val prices: List<String>,
    @SerializedName("detail_section")
    val detailSection: List<String>
)

fun DetailInfo.toMenuDetail(): MenuDetail {
    return if(prices.size>1){
        MenuDetail(topImage, thumbImages, productDescription, point, deliveryInfo, deliveryFee, prices[0], prices[1], detailSection )
    }
    else{
        MenuDetail(topImage, thumbImages, productDescription, point, deliveryInfo, deliveryFee, null, prices[0], detailSection )
    }
}