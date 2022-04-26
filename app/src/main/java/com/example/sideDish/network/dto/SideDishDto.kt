package com.example.sideDish.network.dto

import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.Item
import com.google.gson.annotations.SerializedName


data class Body(
    val alt: String,
    val badge: List<String>?,
    @SerializedName("delivery_type")
    val deliveryType: List<String>,
    val description: String,
    @SerializedName("detail_hash")
    val detailHash: String,
    val image: String,
    @SerializedName("n_price")
    val originalPrice: String?,
    @SerializedName("s_price")
    val discountedPrice: String,
    val title: String
)

data class SideDishDto(
    val statusCode: Int,
    val body: List<Body>
)

fun SideDishDto.toItems(foodCategory: FoodCategory): List<Item> {
    val mutableList = mutableListOf<Item>()
    mutableList.add(Item.Section(foodCategory))
    body.forEach {
        val foodInfo = Item.FoodInfo(
            it.alt,
            it.badge ?: listOf(),
            it.deliveryType,
            it.description,
            it.detailHash,
            it.image,
            it.originalPrice ?: "",
            it.discountedPrice,
            it.title
        )
        mutableList.add(foodInfo)
    }
    return mutableList.toList()
}