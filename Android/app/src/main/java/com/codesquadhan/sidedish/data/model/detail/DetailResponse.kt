package com.codesquadhan.sidedish.data.model.detail

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("deliveryInfo")
    val deliveryInfo: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("detailImage")
    val detailImage: List<String> = listOf(),
    @SerializedName("fee")
    val fee: Int = 0,
    @SerializedName("freeShippingStartingPrice")
    val freeShippingStartingPrice: Int,
    @SerializedName("mainImage")
    val mainImage: List<String> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("price")
    val price: Int = 0,
    @SerializedName("point")
    val point: Int = 0,
    @SerializedName("saleType")
    val saleType: String = "",
    @SerializedName("salePrice")
    val salePrice: Int = 0,
    @SerializedName("stock")
    val stock: Int = 0
)