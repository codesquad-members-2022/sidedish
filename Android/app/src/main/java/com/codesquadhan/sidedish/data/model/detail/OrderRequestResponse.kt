package com.codesquadhan.sidedish.data.model.detail

import com.google.gson.annotations.SerializedName

data class OrderRequestResponse(
    @SerializedName("fee")
    val fee: Int,
    @SerializedName("menuName")
    val menuName: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("salePrice")
    val salePrice: Int,
    @SerializedName("userId")
    val userId: Int
)