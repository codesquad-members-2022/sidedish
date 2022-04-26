package com.example.sidedish.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MenuData(
    @SerializedName("count")
    val count: Int,
    @SerializedName("products")
    val products: List<Products>
) : Serializable

data class Products(
    @SerializedName("productId")
    val productId: Int,
    @SerializedName("productName")
    val productName: String,
    @SerializedName("imageURL")
    val imageURL: String?,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("discountPrice")
    val discountPrice: Int,
    @SerializedName("discountName")
    val discountName: String?
) : Serializable