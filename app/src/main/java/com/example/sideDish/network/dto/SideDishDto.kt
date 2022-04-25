package com.example.sideDish.network.dto

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body

data class Body(
    val alt: String,
    val badge: List<String>,
    @SerializedName("delivery_type")
    val deliveryType: List<String>,
    val description: String,
    @SerializedName("detail_hash")
    val detailHash: String,
    val image: String,
    @SerializedName("n_price")
    val originalPrice: String,
    @SerializedName("s_price")
    val discountedPrice: String,
    val title: String
)

data class SideDishDto(
    val statusCode: Int,
    val body: List<Body>
)