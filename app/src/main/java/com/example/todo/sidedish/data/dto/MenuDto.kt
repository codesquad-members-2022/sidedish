package com.example.todo.sidedish.data.dto


import com.example.todo.sidedish.model.Menu
import com.google.gson.annotations.SerializedName

data class MenuDto(
    @SerializedName("body")
    val body: List<Body>?,
    @SerializedName("statusCode")
    val statusCode: Int,
)

data class Body(
    @SerializedName("detail_hash")
    val detailHash: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("alt")
    val alt: String,
    @SerializedName("delivery_type")
    val deliveryType: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("n_price")
    val nPrice: String?,
    @SerializedName("s_price")
    val sPrice: String,
    @SerializedName("badge")
    val badge: List<String>?,
)

fun Body.toMenu(): Menu =
    Menu(detailHash, image, alt, deliveryType, title, description, nPrice, sPrice, badge)