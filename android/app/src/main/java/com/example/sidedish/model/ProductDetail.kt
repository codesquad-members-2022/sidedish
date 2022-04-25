package com.example.sidedish.model

import com.google.gson.annotations.SerializedName

data class ProductDetail(
    @SerializedName("productId")
    val productId: Int,
    @SerializedName("productName")
    val productName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("representImages")
    val representImages: List<RepresentImages>,
    @SerializedName("representImages")
    val detailImages: List<DetailImages>,
    @SerializedName("price")
    val price: Int,
    @SerializedName("discountPrice")
    val discountPrice: Int,
    @SerializedName("stockQuantity")
    val stockQuantity: Int,
    @SerializedName("eventInfo")
    val eventInfo: String
)

data class RepresentImages(
    @SerializedName("imageId")
    val imageId: Int,
    @SerializedName("imageURL")
    val imageURL: String?,
    @SerializedName("representYn")
    val representYn: Boolean,
    @SerializedName("sequence")
    val sequence: Int
)

data class DetailImages(
    @SerializedName("imageId")
    val imageId: Int,
    @SerializedName("imageURL")
    val imageURL: String?,
    @SerializedName("representYn")
    val representYn: Boolean,
    @SerializedName("sequence")
    val sequence: Int
)
